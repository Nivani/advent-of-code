package nvn.adventofcode.day1

fun solveCaptcha(input: String): Int = input.foldIndexed(0, { index, acc, char ->
    val matchIndex = (index + 1) % input.length
    val matchChar = input[matchIndex]

    if (char == matchChar)
        acc + "$char".toInt()
    else
        acc
})