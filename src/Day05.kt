fun main() {
    fun part1(moves: List<String>, stacks: Map<Int, List<Char>>): Int {
        var mutableStacks = stacks
        for (moveInstruction in moves) {
            val moveList = moveInstruction.split(" from ")
            val quantity = moveList.first().last().digitToInt()
            val from = moveList.last().first().digitToInt()
            val to = moveList.last().last().digitToInt()

            mutableStacks = updateStacks(quantity, from, to, stacks)
        }
        TODO()
    }

    fun part2(): Int {
        TODO()
    }

    val moveInstructions = readInputAsList("Day05Input")
    val crateArrangement = readInputAsList("Day05Map")
    val cratePositions = listOf(1, 5, 9, 13, 17, 21, 25, 29, 33)
    val stacks = arrangementToMapOfStacks(crateArrangement, cratePositions)
    println(part1(moveInstructions, stacks))
    println(part2())
}

private fun updateStacks(quantity: Int, from: Int, to: Int, stacks: Map<Int, List<Char>>): Map<Int, List<Char>> {
    TODO()
}

private fun arrangementToMapOfStacks(crateArrangement: List<String>, cratePositions: List<Int>): Map<Int, List<Char>> {
    val stacks = mutableMapOf<Int, List<Char>>()
    cratePositions.forEachIndexed { index, cratePos ->
        val crateStackList: MutableList<Char> = emptyList<Char>().toMutableList()
        for (cratePlacements in crateArrangement) {
            if (cratePlacements[cratePos].isLetter()) {
                crateStackList += cratePlacements[cratePos]
            }
        }
        stacks[index+1] = crateStackList
    }
    return stacks
}
