package nvn.adventofcode.day7

import java.io.File

fun main(args: Array<String>) {

    println("Part 1")
    println("------")

    val lines = File("input/day7/day7-input")
            .readLines()
            .map({ parseLine(it) })
            .filter({ it.isPresent })
            .map({ it.get() })
    val rootNode = createTree(lines)
    println(rootNode.name)
}