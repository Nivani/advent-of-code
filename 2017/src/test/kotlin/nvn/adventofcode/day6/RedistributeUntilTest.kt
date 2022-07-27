package nvn.adventofcode.day6

import org.junit.Test
import kotlin.test.asserter

class RedistributeUntilTest {
    @Test
    fun testSeenBeforeExample() {
        val start = listOf(0, 2, 7, 0)

        asserter.assertEquals("Expected count to be 5", 5, redistributeUntilSeenBefore(start).count)
    }

    @Test
    fun testLoopExample() {
        val start = listOf(2, 4, 1, 2)

        asserter.assertEquals("Expected count to be 4", 4, redistributeUntilLoop(start).count)
    }
}