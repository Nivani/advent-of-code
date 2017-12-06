package nvn.adventofcode.day5

import java.io.File

fun main(args: Array<String>) {
    val offsets = File("input/day5/day5-input")
            .readLines()
            .map({ it.toInt() })

    println("Part 1")
    println("------")
    println(numberOfJumpsToExit(offsets, Int.MAX_VALUE))

    println()
    println("Part 2")
    println("------")

    println(numberOfJumpsToExit(offsets, 3))
}