package nvn.adventofcode.day8

fun applyInstructions(instructions: List<Instruction>): Map<String, List<Int>> = instructions.fold(
        mutableMapOf(),
        { registry: MutableMap<String, MutableList<Int>>, instruction ->
            if (conditionApplies(instruction, registry)) {
                val originalValue = getRegistryValue(registry, instruction.operationRegister)
                val newValue = instruction.operation.apply(originalValue, instruction.operationValue)
                if (registry.containsKey(instruction.operationRegister)) {
                    registry.getValue(instruction.operationRegister).add(newValue)
                } else {
                    registry.set(instruction.operationRegister, mutableListOf(newValue))
                }
            }
            registry
        }
)

private fun conditionApplies(instruction: Instruction, registry: Map<String, List<Int>>): Boolean {
    return instruction.condition.applies(
            getRegistryValue(registry, instruction.conditionRegister),
            instruction.conditionValue
    )
}

private fun getRegistryValue(registry: Map<String, List<Int>>, register: String): Int =
        registry.getOrDefault(register, listOf(0)).last()
