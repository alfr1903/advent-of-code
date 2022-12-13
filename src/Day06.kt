fun main() {
    fun part1(input: String): Int {
        return input.windowed(4).indexOfFirst { it.allUnique() } + 4
    }

    fun part2(input: String): Int {
        return input.windowed(14).indexOfFirst { it.allUnique() } + 14
    }

    val input = readInput("Day06Input")
    println(part1(input))
    println(part2(input))
}

private fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)
