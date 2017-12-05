package nvn.adventofcode.day3

class Coord(val x: Int, val y: Int) {

    operator fun plus(other: Coord): Coord {
        return Coord(x + other.x, y + other.y)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Coord

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    override fun toString(): String {
        return "Coord(x=$x, y=$y)"
    }


}