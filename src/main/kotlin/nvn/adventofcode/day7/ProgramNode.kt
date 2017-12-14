package nvn.adventofcode.day7

class ProgramNode(
        val name: String,
        var supportedBy: ProgramNode?
) {

    override fun toString(): String {
        return "ProgramNode(name='$name', supportedBy=$supportedBy)"
    }
}