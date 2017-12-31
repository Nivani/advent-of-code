package nvn.adventofcode.day8

import org.junit.Test
import kotlin.test.asserter

import nvn.adventofcode.day8.Operation.*
import nvn.adventofcode.day8.Condition.*

class ApplyInstructionsTest {
    @Test
    fun testExample() {
        val instructions = listOf(
                Instruction("b", PLUS, 5, "a", IS_GREATER, 1),
                Instruction("a", PLUS, 1, "b", IS_SMALLER, 5),
                Instruction("c", MINUS, -10, "a", IS_GREATER_OR_EQUALS, 1),
                Instruction("c", PLUS, -20, "c", EQUALS, 10)
        )

        val registry = applyInstructions(instructions)

        val expectedRegistry = mapOf(("a" to 1), ("c" to -10))

        asserter.assertEquals("Expected a=1, c=-10", expectedRegistry, registry)
    }
}

//b inc 5 if a > 1
//a inc 1 if b < 5
//c dec -10 if a >= 1
//c inc -20 if c == 10
