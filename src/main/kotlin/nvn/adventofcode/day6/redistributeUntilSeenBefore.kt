package nvn.adventofcode.day6

fun countRedistributeUntilSeenBefore(initialMemoryBank: List<Int>): Int {
    var count = 0
    var seenBefore = HashSet<List<Int>>()

    var memoryBank = initialMemoryBank
    while(!seenBefore.contains(memoryBank)) {
        seenBefore.add(memoryBank)
        memoryBank = redistributeHighest(memoryBank)
        count++
    }

    return count
}