package nvn.adventofcode.day7

class ProgramNode(
        val name: String,
        var weight: Int,
        val supports: MutableList<ProgramNode> = mutableListOf(),
        var supportedBy: ProgramNode? = null
) {
    override fun toString(): String {
        return "ProgramNode(name='$name', supportedBy=$supportedBy)"
    }
}