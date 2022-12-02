import java.io.File

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

    val input = File("src/Day01Input.txt").readText()
    println(part1(input))
    println(part2(input))
}
