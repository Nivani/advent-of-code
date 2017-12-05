package nvn.adventofcode.day3

import java.util.*

fun coordinateOf(step: Int): Coord {
    var currentStep = 0

    return traverseSpiralToResult { coord ->
        currentStep++

        if (currentStep == step)
            Optional.of(coord)
        else
            Optional.empty()
    }
}