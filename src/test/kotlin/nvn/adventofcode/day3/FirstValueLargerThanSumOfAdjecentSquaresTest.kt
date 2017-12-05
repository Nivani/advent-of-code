package nvn.adventofcode.day3

import org.junit.Test
import kotlin.test.asserter

class FirstValueLargerThanSumOfAdjecentSquaresTest {
    @Test
    fun testExamplesPart2() {
        val examples = arrayOf(
                Pair(1, 2),
                Pair(4, 5),
                Pair(26, 54),
                Pair(122, 133),
                Pair(747, 806),
                Pair(347991, 349975)
        )

        examples.forEach { (inputValue, expectedLargerValue) ->
            val firstLargerValue = firstValueLargerThanSumOfAdjecentSquares(inputValue)
            asserter.assertEquals(
                    "Expected first larger value than $inputValue to be $expectedLargerValue",
                    expectedLargerValue,
                    firstLargerValue
            )
        }
    }
}