package nvn.adventofcode.day8

import java.io.File

fun main(args: Array<String>) {

    println("Part 1")
    println("------")

    val instructions = File("input/day8/day8-input")
            .readLines()
            .map({ parseLine(it) })
            .filter({ it.isPresent })
            .map({ it.get() })

    val registry = applyInstructions(instructions)

    println(findGreatestValue(registry))

    println()
    println("Part 2")
    println("------")

    println(findGreatestValueEver(registry))
}