package nvn.adventofcode.day7

import java.util.*

data class InputLine(
        val name: String,
        val number: Int,
        val supports: List<String>
)

private val lineMatcher = "([a-zA-Z]+)\\s+\\(([0-9]+)\\)(\\s+-> ([a-zA-Z\\s,]+))?".toRegex()

fun parseLine(line: String): Optional<InputLine> {
    val match = lineMatcher.matchEntire(line)
    return if (match != null) {
        val groupValues = match.groupValues
        val supports = if (groupValues[3].isNotEmpty()) {
            match.groupValues[4].split(",").map({ it.trim() })
        } else {
            emptyList()
        }
        Optional.of(
                InputLine(
                        groupValues[1],
                        groupValues[2].toInt(),
                        supports
                )
        )
    } else {
        Optional.empty()
    }
}