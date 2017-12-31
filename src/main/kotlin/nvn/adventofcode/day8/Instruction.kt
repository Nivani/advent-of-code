package nvn.adventofcode.day8

data class Instruction(
        val operationRegister: String,
        val operation: Operation,
        val operationValue: Int,
        val conditionRegister: String,
        val condition: Condition,
        val conditionValue: Int
)

enum class Operation {
    PLUS { override fun apply(val1: Int, val2: Int) = val1 + val2 },
    MINUS { override fun apply(val1: Int, val2: Int) = val1 - val2 };

    abstract fun apply(val1: Int, val2: Int): Int
}

enum class Condition {
    EQUALS { override fun applies(val1: Int, val2: Int) = val1 == val2 },
    DIFFERS { override fun applies(val1: Int, val2: Int) = val1 != val2 },
    IS_GREATER { override fun applies(val1: Int, val2: Int) = val1 > val2 },
    IS_GREATER_OR_EQUALS { override fun applies(val1: Int, val2: Int) = val1 >= val2 },
    IS_SMALLER { override fun applies(val1: Int, val2: Int) = val1 < val2 },
    IS_SMALLER_OR_EQUALS { override fun applies(val1: Int, val2: Int) = val1 <= val2 };

    abstract fun applies(val1: Int, val2: Int): Boolean
}