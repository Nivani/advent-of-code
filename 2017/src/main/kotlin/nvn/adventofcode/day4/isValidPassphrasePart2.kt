package nvn.adventofcode.day4

fun isValidPassphrasePart2(line: String): Boolean {
    val words = line.split("\\s+".toRegex())
    val wordsWithLettersAlphabetic = words.map({ word ->
        val sortedCharArray = word.toCharArray()
        sortedCharArray.sort()
        String(sortedCharArray)
    })
    val uniqueWords = wordsWithLettersAlphabetic.toSet()
    return wordsWithLettersAlphabetic.count() == uniqueWords.count()
}
