package nvn.adventofcode.day4

import java.io.File

fun main(args: Array<String>) {
    println("Part 1")
    println("------")

    val lines = File("input/day4/day4-part1-input").readLines()

    println(
            lines
                    .filter({ passphrase -> isValidPassphrase(passphrase) })
                    .count()
    )

//    println()
//    println("Part 2")
//    println("------")
//
//    println(firstValueLargerThanSumOfAdjecentSquares(347991))
}