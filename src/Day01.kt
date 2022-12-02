fun main() {
    fun part1(calInput: String): Int {
        val calorieChunks = calInput.split("\n\n").map { calPartial ->
            calPartial.lines().sumOf { it.toInt() }
        }
        return calorieChunks.max()
    }

    fun part2(calInput: String): Int {
        val calorieChunks = calInput.split("\n\n").map { calPartial ->
            calPartial.lines().sumOf { it.toInt() }
        }
        return calorieChunks.sorted().takeLast(3).sum()
    }

    val input = readInput("Day01Input")
    println(part1(input))
    println(part2(input))
}
