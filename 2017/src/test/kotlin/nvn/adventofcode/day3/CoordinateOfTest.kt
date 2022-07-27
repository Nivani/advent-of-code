package nvn.adventofcode.day3

import org.junit.Test
import kotlin.test.asserter

class CoordinateOfTest {
    @Test
    fun testExamples() {
        val examples = arrayOf(
                Pair(1, Coord(0, 0)),
                Pair(7, Coord(-1, -1)),
                Pair(43, Coord(-3, -3)),
                Pair(37, Coord(-3, 3)),
                Pair(15, Coord(0, 2)),
                Pair(12, Coord(2, 1)),
                Pair(40, Coord(-3, 0)),
                Pair(9, Coord(1, -1)),
                Pair(4, Coord(0, 1))
        )

        examples.forEach { (step, expectedCoord) ->
            val coord = coordinateOf(step)
            asserter.assertEquals("expected step $step to be at coord $expectedCoord", expectedCoord, coord)
        }
    }
}