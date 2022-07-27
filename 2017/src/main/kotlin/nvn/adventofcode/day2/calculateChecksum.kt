package nvn.adventofcode.day2

fun calculateChecksum(input: String): Int =
        parseRows(input)
                .map({ row -> minMaxDifferenceRowResult(row) })
                .sum()

fun calculateChecksumPart2(input: String): Int =
        parseRows(input)
                .map({ row -> evenlyDivisibleValuesRowResult(row) })
                .sum()

private fun parseRows(input: String): List<List<Int>> = input
        .lines()
        .map({ line ->
            line
                    .trim()
                    .split("\\s+".toRegex())
                    .map({ it.toInt() })
        })

private fun minMaxDifferenceRowResult(row: Iterable<Int>): Int =
        row
                .fold(MinMax(), { minMax, item -> minMax.handleValue(item) })
                .difference

private fun evenlyDivisibleValuesRowResult(row: Iterable<Int>): Int {
    row.forEachIndexed { i, a ->
        row.forEachIndexed { j, b ->
            if (i != j && a % b == 0)
                return a / b
        }
    }

    throw IllegalArgumentException("Found a row where no element evenly divides another element")
}