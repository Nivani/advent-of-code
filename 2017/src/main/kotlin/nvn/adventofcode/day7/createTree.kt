package nvn.adventofcode.day7

fun createTree(input: List<InputLine>): ProgramNode {
    val nodesByName = input.fold(HashMap<String, ProgramNode>(), { nodesByName, inputLine ->
        if (!nodesByName.containsKey(inputLine.name)) {
            nodesByName.put(inputLine.name, ProgramNode(inputLine.name, inputLine.weight))
        }

        val node = nodesByName.getValue(inputLine.name)
        node.weight = inputLine.weight

        inputLine.supports.forEach({
            if (!nodesByName.containsKey(it)) {
                nodesByName.put(it, ProgramNode(it, 0))
            }

            val supportedNode = nodesByName.getValue(it)
            node.supports.add(supportedNode)
            supportedNode.supportedBy = node
        })

        nodesByName
    })

    return nodesByName.values.first({ it.supportedBy == null })
}