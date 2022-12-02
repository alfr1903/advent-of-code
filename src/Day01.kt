fun main() {
    fun part1(calInput: List<String>): Int {
        return aggregateCalories(calInput).maxBy { it.value }.value
    }

    fun part2(calInput: List<String>): Int {
        return aggregateCalories(calInput).values.sortedDescending().take(3).sum()
    }

    val input = readInput("Day01Input")
    println(part1(input))
    println(part2(input))
}

fun aggregateCalories(caloriesList: List<String>): MutableMap<Int, Int> {
    val calMap: MutableMap<Int, Int> = mutableMapOf()
    var index = 0
    for (partCals in caloriesList) {
        if (partCals.isNullOrBlank()){
            index++
        } else {
            if (calMap.containsKey(index)) calMap[index] = calMap[index]!! + partCals.toInt()
            else calMap[index] = partCals.toInt()
        }
    }
    return calMap
}
