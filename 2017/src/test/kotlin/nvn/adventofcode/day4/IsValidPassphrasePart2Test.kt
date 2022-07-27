package nvn.adventofcode.day4

import org.junit.Test
import kotlin.test.asserter

class IsValidPassphrasePart2Test {
    @Test
    fun validPassphrase() {
        val validPassphrases = arrayOf(
                "abcde fghij",
                "a ab abc abd abf abj",
                "iiii oiii ooii oooi oooo"
        )

        validPassphrases.forEach({ validPassphrase ->
            asserter.assertTrue("Expected '$validPassphrase' to be a valid passphrase", isValidPassphrasePart2(validPassphrase))
        })
    }

    @Test
    fun invalidPassphrase() {
        val invalidPassphrases = arrayOf(
                "abcde xyz ecdab",
                "oiii ioii iioi iiio"
        )

        invalidPassphrases.forEach({ invalidPassphrase ->
            asserter.assertTrue("Expected '$invalidPassphrase' to be an invalid passphrase", !isValidPassphrasePart2(invalidPassphrase))
        })
    }
}