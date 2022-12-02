const val OPPONENT_ROCK = "A"; const val OPPONENT_PAPER = "B"; const val OPPONENT_SCISSOR = "C"
const val ROCK = "Y"; const val PAPER = "X"; const val SCISSOR = "Z"

enum class HAND(val score: Int) {
    A(1),
    B(2),
    C(3),
    Y(1),
    X(2),
    Z(3),
}

private fun roundScore(roundString: String): Int {
    val roundHands = Pair(roundString.substringBefore(' ').trim(), roundString.substringAfter(' '))
    val theirHand = roundHands.first; val yourHand = roundHands.second
    return HAND.valueOf(yourHand).score + outcome(theirHand, yourHand)
}

private fun outcome(theirHand: String, yourHand: String): Int {
    if (theirHand == OPPONENT_ROCK && yourHand == SCISSOR) return 0
    val score = HAND.valueOf(yourHand).score - HAND.valueOf(theirHand).score
    return if (score < 0) 0 else if (score == 0) 3 else 6
}

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { roundScore(it) }
    }

    fun part2(input: List<String>): Int {
        TODO()
    }

    val input = readInputAsList("Day02Input")
    println(part1(input))
    println(part2(input))
}
