package nvn.adventofcode.day8

fun applyInstructions(instructions: List<Instruction>): Map<String, Int> = instructions.fold(
        mutableMapOf(),
        { registry: MutableMap<String, Int>, instruction ->
            if (conditionApplies(instruction, registry)) {
                val originalValue = getRegistryValue(registry, instruction.operationRegister)
                val newValue = instruction.operation.apply(originalValue, instruction.operationValue)
                registry[instruction.operationRegister] = newValue
            }
            registry
        }
)

private fun conditionApplies(instruction: Instruction, registry: Map<String, Int>): Boolean {
    return instruction.condition.applies(
            getRegistryValue(registry, instruction.conditionRegister),
            instruction.conditionValue
    )
}

private fun getRegistryValue(registry: Map<String, Int>, register: String): Int = registry.getOrDefault(register, 0)
