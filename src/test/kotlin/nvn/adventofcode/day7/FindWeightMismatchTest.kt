package nvn.adventofcode.day7

import org.junit.Test
import kotlin.test.asserter

class FindWeightMismatchTest {
    @Test
    fun testExample() {
        val gyxo = ProgramNode("gxyo", 61)
        val ebii = ProgramNode("ebii", 61)
        val jptl = ProgramNode("jptl", 61)
        val ugml = ProgramNode("ugml", 68, mutableListOf(gyxo, ebii, jptl))

        val pbga = ProgramNode("pbga", 66)
        val havc = ProgramNode("havc", 66)
        val qoyq = ProgramNode("qoyq", 66)
        val padx = ProgramNode("padx", 45, mutableListOf(pbga, havc, qoyq))

        val ktlj = ProgramNode("ktlj", 57)
        val cntj = ProgramNode("cntj", 57)
        val xhth = ProgramNode("xhth", 57)
        val fwft = ProgramNode("fwft", 72, mutableListOf(ktlj, cntj, xhth))


        val tknk = ProgramNode("tknk", 41, mutableListOf(ugml, padx, fwft))

        val result = findWeightMismatch(tknk).get()

        asserter.assertEquals("ugml's weight should be 60", 60, result)
    }
}