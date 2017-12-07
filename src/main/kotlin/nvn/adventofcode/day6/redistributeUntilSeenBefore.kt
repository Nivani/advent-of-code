package nvn.adventofcode.day6

fun redistributeUntilSeenBefore(initialMemoryBank: List<Int>): RedistributeUntilResult {
    val seenBefore = HashSet<List<Int>>()
    return redistributeUntil(initialMemoryBank, { memoryBank ->
        if (!seenBefore.contains(memoryBank)) {
            seenBefore.add(memoryBank)
            true
        } else
            false
    })
}

fun redistributeUntil(initialMemoryBank: List<Int>, shouldRedistribute: (List<Int>) -> Boolean): RedistributeUntilResult {
    var count = 0

    var memoryBank = initialMemoryBank
    while(shouldRedistribute(memoryBank)) {
        memoryBank = redistributeHighest(memoryBank)
        count++
    }

    return RedistributeUntilResult(memoryBank, count)
}

data class RedistributeUntilResult(val memoryBank: List<Int>, val count: Int)