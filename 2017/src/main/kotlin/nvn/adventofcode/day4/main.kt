package nvn.adventofcode.day4

import java.io.File

fun main(args: Array<String>) {
    println("Part 1")
    println("------")

    println(
            File("input/day4/day4-part1-input")
                    .readLines()
                    .filter({ passphrase -> isValidPassphrasePart1(passphrase) })
                    .count()
    )

    println()
    println("Part 2")
    println("------")

    println(
            File("input/day4/day4-part2-input")
                    .readLines()
                    .filter({ passphrase -> isValidPassphrasePart2(passphrase) })
                    .count()
    )
}