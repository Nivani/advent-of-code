package nvn.adventofcode.day6

fun redistributeHighest(memoryBank: List<Int>): List<Int> {
    val highestIndex = findHighestIndex(memoryBank)
    val highestValue = memoryBank[highestIndex]

    val result = memoryBank.toMutableList()
    result[highestIndex] = 0

    for (i in (highestIndex + 1)..(highestIndex + highestValue)) {
        result[i % result.size]++
    }

    return result
}

private fun findHighestIndex(memoryBank: List<Int>): Int {
    var highestIndex = -1
    var highestNumber = Int.MIN_VALUE

    memoryBank.forEachIndexed({ index, numberOfBlocks ->
        if (numberOfBlocks > highestNumber) {
            highestIndex = index
            highestNumber = numberOfBlocks
        }
    })

    return highestIndex
}