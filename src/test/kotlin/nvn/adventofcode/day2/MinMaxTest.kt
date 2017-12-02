package nvn.adventofcode.day2

import org.junit.Test
import kotlin.test.asserter

class MinMaxTest {

    @Test
    fun integersBetween5and10() {
        val minMax = MinMax()

        minMax.handleValue(6)
        minMax.handleValue(7)
        minMax.handleValue(5)
        minMax.handleValue(9)
        minMax.handleValue(10)
        minMax.handleValue(8)

        asserter.assertEquals("min value should be 5", 5, minMax.minValue)
        asserter.assertEquals("max value should be 10", 10, minMax.maxValue)
        asserter.assertEquals("difference should be 5", 5, minMax.difference)
    }



    @Test
    fun singleValue() {
        val minMax = MinMax()

        minMax.handleValue(3)

        asserter.assertEquals("min value should be 3", 3, minMax.minValue)
        asserter.assertEquals("max value should be 3", 3, minMax.maxValue)
        asserter.assertEquals("difference should be 0", 0, minMax.difference)
    }


    @Test
    fun singleValue0() {
        val minMax = MinMax()

        minMax.handleValue(0)

        asserter.assertEquals("min value should be 3", 0, minMax.minValue)
        asserter.assertEquals("max value should be 3", 0, minMax.maxValue)
        asserter.assertEquals("difference should be 0", 0, minMax.difference)
    }

    @Test
    fun testNegativeValues() {
        val minMax = MinMax()

        minMax.handleValue(-4)
        minMax.handleValue(-5)
        minMax.handleValue(-2)

        asserter.assertEquals("min value should be 5", -5, minMax.minValue)
        asserter.assertEquals("max value should be 10", -2, minMax.maxValue)
        asserter.assertEquals("difference should be 0", 3, minMax.difference)
    }

}