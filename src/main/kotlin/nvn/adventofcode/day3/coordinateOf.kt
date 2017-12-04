package nvn.adventofcode.day3

fun coordinateOf(step: Int): Coord = traverseSpiralTo(step, shortcutToCorrectSpiral(step))

private data class State(
        val step: Int,
        val coord: Coord,
        val spiralNr: Int
)

private fun shortcutToCorrectSpiral(step: Int): State {
    var state = State(1, Coord(0, 0), 0)
    var nextSpiral = goToNextSpiral(state)

    while (nextSpiral.step <= step) {
        state = nextSpiral
        nextSpiral = goToNextSpiral(state)
    }

    return state
}

private fun goToNextSpiral(state: State): State {
    val rightUpTraverseAmount = rightUpTraverseAmount(state.spiralNr)
    return State(
            state.step + (2 * rightUpTraverseAmount + 2 * (rightUpTraverseAmount + 1)),
            Coord(state.coord.x - 1, state.coord.y - 1),
            state.spiralNr + 1
    )
}

private fun rightUpTraverseAmount(spiralNumber: Int) = (2 * (spiralNumber + 1)) - 1

private fun traverseSpiralTo(step: Int, initialState: State): Coord {
    var state = initialState

    if (state.step < step) {
        val rightTransform = Coord(1, 0)
        state = traverseInDirection(step, rightUpTraverseAmount(state.spiralNr), rightTransform, state)
    }

    if (state.step < step) {
        val upTransform = Coord(0, 1)
        state = traverseInDirection(step, rightUpTraverseAmount(state.spiralNr), upTransform, state)
    }

    if (state.step < step) {
        val leftTransform = Coord(-1, 0)
        state = traverseInDirection(step, rightUpTraverseAmount(state.spiralNr) + 1, leftTransform, state)
    }

    if (state.step < step) {
        val downTransform = Coord(0, -1)
        state = traverseInDirection(step, rightUpTraverseAmount(state.spiralNr) + 1, downTransform, state)
    }

    return if (state.step == step)
        state.coord
    else
        traverseSpiralTo(step, state.copy(spiralNr = state.spiralNr + 1))
}

private fun traverseInDirection(maxStep: Int, maxDistance: Int, directionTransform: Coord, initialState: State): State {
    var state = initialState
    var distance = 0

    while (state.step < maxStep && distance < maxDistance) {
        val newCoord = Coord(state.coord.x + directionTransform.x, state.coord.y + directionTransform.y)
        state = State(
                state.step + 1,
                newCoord,
                state.spiralNr
        )
        distance++
    }

    return state
}