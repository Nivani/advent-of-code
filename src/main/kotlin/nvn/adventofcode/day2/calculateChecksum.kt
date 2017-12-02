package nvn.adventofcode.day2

fun calculateChecksum(input: String): Int  =
        input
                .lines()
                .map({ line ->
                    line
                            .trim()
                            .split("\\s+".toRegex())
                            .map({ it.toInt() })
                            .fold(MinMax(), { minMax, item -> minMax.handleValue(item) })
                            .difference

                })
                .sum()