package nvn.adventofcode.day3

import org.junit.Test
import kotlin.test.asserter

class ManhattanDistanceToStepTest {
    @Test
    fun testExamplesPart1() {
        val examples = arrayOf(
                Pair(1, 0),
                Pair(12, 3),
                Pair(23, 2),
                Pair(1024, 31),
                Pair(347991, 480)
        )

        examples.forEach { (step, expectedDistance) ->
            val distance = manhattanDistanceToStep(step)
            asserter.assertEquals("Expected distance to step $step to be $expectedDistance", expectedDistance, distance)
        }
    }
}