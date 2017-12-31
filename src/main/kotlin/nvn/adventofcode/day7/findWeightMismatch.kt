package nvn.adventofcode.day7

import java.util.*

fun findWeightMismatch(tower: ProgramNode): Optional<Int> {
    val intermediateResult = findWeightMismatchRecursive(tower)
    return intermediateResult.result
}

private fun findWeightMismatchRecursive(tower: ProgramNode): IntermediateResult {
    return if (tower.supports.isEmpty()) {
        return IntermediateResult(Optional.empty(), tower.weight, tower)
    } else {
        val supportingTowerResults = tower.supports.map({ findWeightMismatchRecursive(it) })
        val intermediateResult = Optional.ofNullable(supportingTowerResults.find({ it.result.isPresent }))
        val totalWeight = tower.weight + supportingTowerResults.map({ it.totalWeight }).sum()
        if (intermediateResult.isPresent) {
            IntermediateResult(intermediateResult.get().result, totalWeight, tower)
        } else {
            var otherResult = Optional.empty<IntermediateResult>()

            supportingTowerResults.subList(1, supportingTowerResults.size).forEach({ result ->
                if (!otherResult.isPresent && result.totalWeight != supportingTowerResults[0].totalWeight) {
                    otherResult = Optional.of(result)
                }
            })

            if (otherResult.isPresent) {
                IntermediateResult(Optional.of(supportingTowerResults[0].tower.weight - Math.abs(supportingTowerResults[0].totalWeight - otherResult.get().totalWeight)), totalWeight, tower)
            } else {
                IntermediateResult(Optional.empty(), totalWeight, tower)
            }
        }
    }
}

private data class IntermediateResult(
        val result: Optional<Int>,
        val totalWeight: Int,
        val tower: ProgramNode
)