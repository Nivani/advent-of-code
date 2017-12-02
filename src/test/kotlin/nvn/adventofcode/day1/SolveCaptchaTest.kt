package nvn.adventofcode.day1

import org.junit.Test
import kotlin.test.asserter

class SolveCaptchaTest {
    @Test
    fun testExamplesPart1() {
        val examples = arrayOf(
                Pair("1122", 3),
                Pair("1111", 4),
                Pair("1234", 0),
                Pair("91212129", 9)
        )

        examples.forEach {
            val result = solveCaptcha(it.first)
            asserter.assertEquals(
                    "Expected solveCaptcha(${it.first}) to be equal ${it.second}, but it was $result",
                    result, it.second
            )
        }
    }

    @Test
    fun testExamplesPart2() {
        val examples = arrayOf(
                Pair("1212", 6),
                Pair("1221", 0),
                Pair("123425", 4),
                Pair("123123", 12),
                Pair("12131415", 4)
        )

        examples.forEach {
            val result = solveCaptchaPart2(it.first)
            asserter.assertEquals(
                    "Expected solveCaptchaPart2(${it.first}) to be equal ${it.second}, but it was $result",
                    result, it.second
            )
        }
    }
}