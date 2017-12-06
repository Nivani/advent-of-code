package nvn.adventofcode.day4

fun isValidPassphrase(line: String): Boolean {
    val words = line.split("\\s+".toRegex())
    val uniqueWords = words.toSet()
    return words.count() == uniqueWords.count()
}
