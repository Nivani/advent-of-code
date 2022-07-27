package nvn.adventofcode.day6

import org.junit.Test
import kotlin.test.asserter

class RedistributeHighestTest {
    @Test
    fun testExamplesPart1() {
        val start = listOf(0, 2, 7, 0)
        val expectedStates = listOf(
                listOf(2, 4, 1, 2),
                listOf(3, 1, 2, 3),
                listOf(0, 2, 3, 4),
                listOf(1, 3, 4, 1),
                listOf(2, 4, 1, 2)
        )

        var previousResult = start
        expectedStates.forEachIndexed({ i, expectedState ->
            val result = redistributeHighest(previousResult)
            asserter.assertEquals("Expected state after ${i+1} iterations to be $expectedState", expectedState, result)
            previousResult = result
        })
    }
}