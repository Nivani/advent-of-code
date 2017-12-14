package nvn.adventofcode.day7

import org.junit.Test
import kotlin.test.asserter

class ParseLineTest {
    @Test
    fun testLineWithoutSupports() {
        val inputLine = parseLine("ngsgolg (76)")
        val expectedResult = InputLine("ngsgolg", 76, emptyList())

        asserter.assertTrue("Expected parse to work", inputLine.isPresent)
        asserter.assertEquals("Expected name to be 'ngsgolg'", expectedResult, inputLine.get())
    }

    @Test
    fun testLineWithSupports() {
        val inputLine = parseLine("wjjov (97) -> wmiuyq, xwxof, ycpxqjz")
        val expectedResult = InputLine("wjjov", 97, listOf("wmiuyq", "xwxof", "ycpxqjz"))

        asserter.assertTrue("Expected parse to work", inputLine.isPresent)
        asserter.assertEquals("Expected name to be 'ngsgolg'", expectedResult, inputLine.get())
    }
}