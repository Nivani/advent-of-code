package nvn.adventofcode.day2


class MinMax {
    var minValue = Int.MAX_VALUE
        private set

    var maxValue = Int.MIN_VALUE
        private set

    val difference: Int
        get() = this.maxValue - this.minValue

    fun handleValue(value: Int): MinMax {
        if (value < this.minValue) {
            this.minValue = value
        }
        if (value > this.maxValue) {
            this.maxValue = value
        }
        return this
    }
}