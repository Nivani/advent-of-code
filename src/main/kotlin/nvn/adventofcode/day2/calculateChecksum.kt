package nvn.adventofcode.day2

fun calculateChecksum(input: String, calculateRowResult: (Array<Int>) -> Int = { minMaxDifferenceRowResult(it) }): Int  =
        input
                .lines()
                .map({ line ->
                    val row = line
                            .trim()
                            .split("\\s+".toRegex())
                            .map({ it.toInt() })
                    calculateRowResult(row.toTypedArray())
                })
                .sum()

fun calculateChecksumPart2(input: String): Int  = calculateChecksum(input, { evenlyDivisibleValuesRowResult(it) })

fun minMaxDifferenceRowResult(row: Array<Int>): Int =
        row
                .fold(MinMax(), { minMax, item -> minMax.handleValue(item) })
                .difference

fun evenlyDivisibleValuesRowResult(row: Array<Int>): Int {
    row.forEachIndexed { i, a ->
        row.forEachIndexed { j, b ->
            if (i != j && a % b == 0)
                return a / b
        }
    }

    throw IllegalArgumentException("Found a row where no element evenly divides another element")
}