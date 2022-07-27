package nvn.adventofcode.day5

fun numberOfJumpsToExit(offsets: List<Int>, decreaseBoundary: Int): Int = numberOfJumpsToExit(
        offsets.toMutableList(),
        0,
        0,
        decreaseBoundary
)

private tailrec fun numberOfJumpsToExit(
        offsets: MutableList<Int>,
        position: Int,
        count: Int,
        decreaseBoundary: Int
): Int {
    return if (position < 0 || position >= offsets.size) {
        count
    } else {
        val jumpDistance = offsets[position]
        offsets[position] = if (jumpDistance < decreaseBoundary) jumpDistance + 1 else jumpDistance - 1
        numberOfJumpsToExit(
                offsets,
                position + jumpDistance,
                count + 1,
                decreaseBoundary
        )
    }
}