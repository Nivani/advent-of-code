package nvn.adventofcode.day7

fun createTree(input: List<InputLine>): ProgramNode {
    val nodesByName = input.fold(HashMap<String, ProgramNode>(), { nodesByName, inputLine ->
        if (!nodesByName.containsKey(inputLine.name)) {
            nodesByName.put(inputLine.name, ProgramNode(inputLine.name, null))
        }

        val node = nodesByName.getValue(inputLine.name)

        inputLine.supports.forEach({
            if (!nodesByName.containsKey(it)) {
                nodesByName.put(it, ProgramNode(it, null))
            }

            nodesByName.getValue(it).supportedBy = node
        })

        nodesByName
    })

    return nodesByName.values.first({ it.supportedBy == null })
}