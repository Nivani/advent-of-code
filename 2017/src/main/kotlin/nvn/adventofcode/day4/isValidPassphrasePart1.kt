package nvn.adventofcode.day4

fun isValidPassphrasePart1(line: String): Boolean {
    val words = line.split("\\s+".toRegex())
    val uniqueWords = words.toSet()
    return words.count() == uniqueWords.count()
}
