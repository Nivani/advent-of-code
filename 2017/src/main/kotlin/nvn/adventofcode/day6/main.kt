package nvn.adventofcode.day6

fun main(args: Array<String>) {

    println("Part 1")
    println("------")

    val part1Result = redistributeUntilSeenBefore(listOf(4, 1, 15, 12, 0, 9, 9, 5, 5, 8, 7, 3, 14, 5, 12, 3))
    println(part1Result.count)

    println()
    println("Part 2")
    println("------")

    println(redistributeUntilLoop(part1Result.memoryBank).count)
}