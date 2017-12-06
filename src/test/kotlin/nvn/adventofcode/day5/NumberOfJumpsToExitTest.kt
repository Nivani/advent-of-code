package nvn.adventofcode.day5

import org.junit.Test
import kotlin.test.asserter

class NumberOfJumpsToExitTest {
    @Test
    fun testExamplePart1() {
        val input = listOf(0, 3, 0, 1, -3)
        asserter.assertEquals(
                "expected jumps to exit to be 5",
                5,
                numberOfJumpsToExit(input, Int.MAX_VALUE)
        )
    }

    @Test
    fun testExamplePart2() {
        val input = listOf(0, 3, 0, 1, -3)
        asserter.assertEquals(
                "expected jumps to exit to be 10",
                10,
                numberOfJumpsToExit(input, 3)
        )
    }
}