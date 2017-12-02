package nvn.adventofcode.day2

import org.junit.Test
import kotlin.test.asserter

class CalculateChecksumTest {
    @Test
    fun testExample() {
        val input = "5 1 9 5\n" +
                "7 5 3\n" +
                "2 4 6 8"

        val checksum = calculateChecksum(input)

        asserter.assertEquals("Checksum from example should be 18", 18, checksum)
    }

    @Test
    fun testUnevenInput() {
        val input = "50 10 90 50\n" +
                "7  5  3\n" +
                "2  4  6  8  "

        val checksum = calculateChecksum(input)

        asserter.assertEquals("Checksum from example should be 90", 90, checksum)
    }
}