import java.util.ArrayDeque
import java.util.Deque

fun main() {
    fun part1(input: List<String>): Int {
        return solve(input)
    }

    fun part2(comingSoon: Any): Int {
        TODO()
    }
    print(part1(testInput.lines())); println(" 48381165")

    val input = readInputAsList("Day07Input")
    println(part1(input))
    println(part2(input))
}

private fun String.isCdBackCommand() = this == "$ cd .."
private fun String.isCdCommand() = this.startsWith("$ cd")
private fun String.isLsCommand() = this.startsWith("$ cd")
private fun String.isDir() = this.startsWith("dir")
private fun String.isFile() = this.first().isDigit()
private fun String.getDir() = this.substringAfterLast(" ")
private fun String.getFileSize():Int = this.substringBefore(" ").toInt()

private fun solve(input: List<String>): Int {
    val currentDir: Deque<String> = ArrayDeque()
    val map = mutableMapOf<String, Int>()
    val visited = emptySet<String>().toMutableSet()
    for (line in input) {
        when {
            line.isCdBackCommand() -> {
                visited += currentDir.first
                val prevCurrent = currentDir.first
                currentDir.removeFirst()
                map[currentDir.first] = map[currentDir.first]!! + map[prevCurrent]!!

            }
            line.isCdCommand() -> {
                if (visited.isNotEmpty()) visited += currentDir.first
                currentDir.addFirst(line.getDir())
                if (currentDir.first !in visited) map[currentDir.first] = 0
            }
            line.isFile() && currentDir.first !in visited ->
                map[currentDir.first] = map[currentDir.first]!! + line.getFileSize()
        }
    }
    return map.values.sum()
}

val testInput =
"""${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k"""






