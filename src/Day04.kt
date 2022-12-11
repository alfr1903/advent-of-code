fun main() {
    fun part1(input: List<String>): Int = input.filter { hasCompleteOverlap(it) }.size
    fun part2(input: List<String>): Int = input.filter { hasPartialOverlap(it) }.size

    val input = readInputAsList("Day04Input")
    println(part1(input))
    println(part2(input))
}

private fun hasCompleteOverlap(inp: String): Boolean {
    val ranges: List<String> = inp.split(",") // 90-96,18-39 etc.
    val firstRange: IntRange = ranges.first().split("-").first().toInt()..ranges.first().split("-").last().toInt()
    val secondRange: IntRange = ranges.last().split("-").first().toInt()..ranges.last().split("-").last().toInt()
    return (firstRange.first <= secondRange.first && firstRange.last >= secondRange.last)
            || (secondRange.first <= firstRange.first && secondRange.last >= firstRange.last)
}

private fun hasPartialOverlap(inp: String): Boolean {
    val ranges: List<String> = inp.split(",") // 90-96,18-39 etc.
    val firstRange: IntRange = ranges.first().split("-").first().toInt()..ranges.first().split("-").last().toInt()
    val secondRange: IntRange = ranges.last().split("-").first().toInt()..ranges.last().split("-").last().toInt()
    return (firstRange.contains(secondRange.first) || firstRange.contains(secondRange.last))
            || (secondRange.contains(firstRange.first) || secondRange.contains(firstRange.last))
}
