package nvn.adventofcode.day1

fun solveCaptchaPart2(input: String): Int = solveCaptcha(input, { it + (input.length / 2) })

fun solveCaptcha(input: String, matchingStrategy: (Int) -> Int = { it + 1 }): Int = input.foldIndexed(0, { index, acc, char ->
    val matchIndex = matchingStrategy(index) % input.length
    val matchChar = input[matchIndex]

    if (char == matchChar)
        acc + "$char".toInt()
    else
        acc
})