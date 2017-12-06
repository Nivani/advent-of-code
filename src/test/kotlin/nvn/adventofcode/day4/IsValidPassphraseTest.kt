package nvn.adventofcode.day4

import org.junit.Test
import kotlin.test.asserter

class IsValidPassphraseTest {
    @Test
    fun validPassphrase() {
        val validPassphrases = arrayOf(
                "aa bb cc dd ee",
                "aa bb cc dd aaa"
        )

        validPassphrases.forEach({ validPassphrase ->
            asserter.assertTrue("Expected '$validPassphrase' to be a valid passphrase", isValidPassphrase(validPassphrase))
        })
    }

    @Test
    fun invalidPassphrase() {
        val invalidPassphrases = arrayOf("aa bb cc dd aa")

        invalidPassphrases.forEach({ invalidPassphrase ->
            asserter.assertTrue("Expected '$invalidPassphrase' to be an invalid passphrase", !isValidPassphrase(invalidPassphrase))
        })
    }
}