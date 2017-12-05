package nvn.adventofcode.day3

import java.util.*

fun firstValueLargerThanSumOfAdjecentSquares(largerThanThis: Int): Int {
    val valueCache = mutableMapOf<Coord, Int>()

    return traverseSpiralToResult({ coord ->
        val value = if (valueCache.isEmpty()) 1 else valueForCoord(coord, valueCache)
        valueCache[coord] = value
        if (value > largerThanThis)
            Optional.of(value)
        else
            Optional.empty()
    })
}

private val coordsAroundTransforms = listOf(
        Coord(1, 1),
        Coord(0, 1),
        Coord(-1, 1),
        Coord(-1, 0),
        Coord(-1, -1),

        Coord(0, -1),
        Coord(1, -1),
        Coord(1, 0)
)

private fun valueForCoord(coord: Coord, valueCache: Map<Coord, Int>): Int = coordsAroundTransforms
        .map({ coordTransform ->
            val coordForValue = coord + coordTransform

            if (valueCache.containsKey(coordForValue))
                valueCache.getValue(coordForValue)
            else
                0
        })
        .sum()