package nvn.adventofcode.day7

import java.util.*

fun findWeightMismatch(tower: ProgramNode): Optional<Int> {
    val intermediateResult = findWeightMismatchRecursive(tower)
    return intermediateResult.result
}

private fun findWeightMismatchRecursive(tower: ProgramNode): IntermediateResult {
    return if (tower.supports.isEmpty()) {
        IntermediateResult(Optional.empty(), tower.weight, tower)
    } else {
        val supportingTowerResults = tower.supports.map({ findWeightMismatchRecursive(it) })
        val intermediateResult = Optional.ofNullable(supportingTowerResults.find({ it.result.isPresent }))
        val totalWeight = tower.weight + supportingTowerResults.map({ it.totalWeight }).sum()

        if (intermediateResult.isPresent) {
            IntermediateResult(intermediateResult.get().result, totalWeight, tower)
        } else {
            findWeightMismatchInCurrentTower(tower, supportingTowerResults, totalWeight)
        }
    }
}

private fun findWeightMismatchInCurrentTower(tower: ProgramNode, supportingTowerResults: List<IntermediateResult>, totalWeight: Int): IntermediateResult {
    val firstResult = supportingTowerResults[0]
    val otherResult = Optional.ofNullable(
            supportingTowerResults
                    .subList(1, supportingTowerResults.size)
                    .find({ it.totalWeight != firstResult.totalWeight })
    )

    return if (otherResult.isPresent) {
        val totalWeightDifference = Math.abs(firstResult.totalWeight - otherResult.get().totalWeight)
        val correctedWeight = firstResult.tower.weight - totalWeightDifference
        IntermediateResult(Optional.of(correctedWeight), totalWeight, tower)
    } else {
        IntermediateResult(Optional.empty(), totalWeight, tower)
    }
}

private data class IntermediateResult(
        val result: Optional<Int>,
        val totalWeight: Int,
        val tower: ProgramNode
)