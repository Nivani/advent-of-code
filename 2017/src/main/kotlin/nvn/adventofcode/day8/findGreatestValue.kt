package nvn.adventofcode.day8

fun findGreatestValue(registry: Map<String, List<Int>>): Int? = registry.values.map({ it.last() }).max()

fun findGreatestValueEver(registry: Map<String, List<Int>>): Int? = registry.values.flatMap({ it }).max()