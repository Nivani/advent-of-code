package nvn.adventofcode.day1

fun solveCaptcha(input: String): Int = input.indices.fold(0, { acc, index ->
    val matchIndex = (index + 1) % input.length
    val char = input[index]
    val matchChar = input[matchIndex]

    if (char == matchChar)
        acc + "$char".toInt()
    else
        acc
})