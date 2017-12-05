package nvn.adventofcode.day3

import java.util.*

private data class State<RESULTTYPE>(
        val result: Optional<RESULTTYPE>,
        val coord: Coord,
        val spiralNr: Int
)

fun <RESULTTYPE> traverseSpiralToResult(elementHandler: (Coord) -> Optional<RESULTTYPE>): RESULTTYPE {

    fun rightUpTraverseAmount(spiralNumber: Int) = (2 * (spiralNumber + 1)) - 1

    fun traverseInDirection(maxDistance: Int, directionTransform: Coord, initialState: State<RESULTTYPE>): State<RESULTTYPE> {
        var state = initialState
        var distance = 0

        while (!state.result.isPresent && distance < maxDistance) {
            val newCoord = state.coord + directionTransform
            state = State(
                    elementHandler(newCoord),
                    newCoord,
                    state.spiralNr
            )
            distance++
        }

        return state
    }

    fun traverseSpiralTo(initialState: State<RESULTTYPE>): RESULTTYPE {
        var state = initialState

        if (!state.result.isPresent) {
            val rightTransform = Coord(1, 0)
            state = traverseInDirection(rightUpTraverseAmount(state.spiralNr), rightTransform, state)
        }

        if (!state.result.isPresent) {
            val upTransform = Coord(0, 1)
            state = traverseInDirection(rightUpTraverseAmount(state.spiralNr), upTransform, state)
        }

        if (!state.result.isPresent) {
            val leftTransform = Coord(-1, 0)
            state = traverseInDirection(rightUpTraverseAmount(state.spiralNr) + 1, leftTransform, state)
        }

        if (!state.result.isPresent) {
            val downTransform = Coord(0, -1)
            state = traverseInDirection(rightUpTraverseAmount(state.spiralNr) + 1, downTransform, state)
        }

        return if (state.result.isPresent)
            state.result.get()
        else
            traverseSpiralTo(state.copy(spiralNr = state.spiralNr + 1))
    }


    val initialCoord = Coord(0, 0)
    val resultOptional = elementHandler(initialCoord)

    return if (resultOptional.isPresent) {
        resultOptional.get()
    } else {
        traverseSpiralTo(State(resultOptional, initialCoord, 0))
    }
}