fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { commonCompartmentLetter(it).toPriority() }
    }

    fun part2(input: List<String>): Any {
        return input.chunked(3).sumOf { commonBadgeLetter(it).toPriority() }
    }

    val input = readInputAsList("Day03Input")
    println(part1(input))
    println(part2(input))
}

private fun commonCompartmentLetter(listEntry: String): Char {
    val firstHalf: String = listEntry.take(listEntry.length / 2)
    val secondHalf: String = listEntry.takeLast(listEntry.length / 2)

    return firstHalf.find { secondHalf.contains(it) }!!
}

private fun commonBadgeLetter(group: List<String>): Char =
    group[0].filter { group[1].contains(it) }.find { group[2].contains(it) }!!

private fun Char.toPriority(): Int = if (this.isLowerCase()) this.code - 96 else this.code - 38
