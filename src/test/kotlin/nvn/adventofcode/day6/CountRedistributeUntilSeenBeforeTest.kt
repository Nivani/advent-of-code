package nvn.adventofcode.day6

import org.junit.Test
import kotlin.test.asserter

class CountRedistributeUntilSeenBeforeTest {
    @Test
    fun testExample() {
        val start = listOf(0, 2, 7, 0)

        asserter.assertEquals("Expected count to be 5", 5, redistributeUntilSeenBefore(start).count)
    }
}