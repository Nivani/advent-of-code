package nvn.adventofcode.day8

import nvn.adventofcode.day8.Condition.*
import nvn.adventofcode.day8.Operation.MINUS
import nvn.adventofcode.day8.Operation.PLUS
import java.util.*

private val lineMatcher = "([a-zA-Z]+)\\s+([a-zA-Z]+)\\s+(-?[0-9]+)\\s+if\\s+([a-zA-Z]+)\\s+([\\!=<>]{1,2})\\s+(-?[0-9]+)".toRegex()

fun parseLine(line: String): Optional<Instruction> {
    val match = lineMatcher.matchEntire(line)
    if (match != null) {
        val groupValues = match.groupValues
        val operation = parseOperation(groupValues[2])
        val operationValue = parseInt(groupValues[3])
        val condition = parseCondition(groupValues[5])
        val conditionValue = parseInt(groupValues[6])
        if (listOf(operation, operationValue, condition, conditionValue).all({ it.isPresent })) {
            return Optional.of(
                    Instruction(
                            groupValues[1],
                            operation.get(),
                            operationValue.get(),
                            groupValues[4],
                            condition.get(),
                            conditionValue.get()
                    )
            )
        }
    }

    return Optional.empty()
}

private fun parseInt(s: String): Optional<Int> = Optional.ofNullable(s.toIntOrNull())

private val operationMapping = mapOf(
        "inc" to PLUS,
        "dec" to MINUS
)

private fun parseOperation(s: String): Optional<Operation> {
    return if (operationMapping.containsKey(s.toLowerCase())) {
        Optional.of(operationMapping.getValue(s.toLowerCase()))
    } else {
        Optional.empty()
    }
}

private val conditionMapping = mapOf(
        "==" to EQUALS,
        "!=" to DIFFERS,
        ">" to IS_GREATER,
        ">=" to IS_GREATER_OR_EQUALS,
        "<" to IS_SMALLER,
        "<=" to IS_SMALLER_OR_EQUALS
)

private fun parseCondition(s: String): Optional<Condition> {
    return if (conditionMapping.containsKey(s.toLowerCase())) {
        Optional.of(conditionMapping.getValue(s.toLowerCase()))
    } else {
        Optional.empty()
    }
}