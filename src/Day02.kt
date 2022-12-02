
fun main() {
    operator fun String.component1() = this[0]
    operator fun String.component2() = this[1]
    operator fun String.component3() = this[2]


    fun part1(input: List<String>): Int {
        fun shapeScore(shape: Char) = (shape - 'X' + 1)

        fun resultScore(theirShape: Char, myShape: Char): Int {
            return when (theirShape to myShape) {
                'B' to 'X', 'C' to 'Y', 'A' to 'Z' -> 0
                'A' to 'X', 'B' to 'Y', 'C' to 'Z' -> 3
                'C' to 'X', 'A' to 'Y', 'B' to 'Z' -> 6
                else -> error("Check you inputs")
            }
        }
        return input.sumOf { round ->
            val (theirShape, _, myShape) = round
            shapeScore(myShape) + resultScore(theirShape, myShape)
        }
    }

    fun part2(input: List<String>): Int {
        fun shapeScore(theirShape: Char, desiredResult: Char): Int {
            return when (theirShape to desiredResult) {
                'A' to 'Y', 'B' to 'X', 'C' to 'Z' -> 1
                'B' to 'Y', 'C' to 'X', 'A' to 'Z' -> 2
                'C' to 'Y', 'A' to 'X', 'B' to 'Z' -> 3
                else -> error("Check you inputs")
            }
        }

        fun resultScore(result: Char) = (result - 'X') * 3

        return input.sumOf { round ->
            val (theirShape, _, result) = round
            shapeScore(theirShape, result) + resultScore(result)
        }
    }

    val input = readInputAsList("Day02Input")
    println(part1(input))
    println(part2(input))
}
