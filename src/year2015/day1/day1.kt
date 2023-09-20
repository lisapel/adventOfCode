package year2015.day1
import java.io.File




   const val file = "src/year2015/day1/input"

    fun getList(file: String): List<String> {
        return file.let { File(file).readText().splitToSequence("").toList() }
    }

    //A-DEL BEFORE
    fun getFloor(list: List<String>): Int {
        val up = list.count { m -> m == "(" }
        val down = list.count { m -> m == ")" }
        return up - down

    }

    //A-DEL AFTER
//  -> https://github.com/agrison/advent-of-code/blob/master/src/main/kotlin/me/grison/aoc/y2015/Day01.kt
    fun getFloor2(list: List<String>): Int {
        val list2 = list.map { input ->
            input.count { it == '(' } - input.count { it == ')' }
        }
        return list2.sum()

    }

    //B-DEL BEFORE
    fun getToBasement(list: List<String>): Int {
        val list2 = list.map { m -> m.replace("(", "1") }.mapNotNull { o ->
            o.replace(")", "-1")
                .toIntOrNull()
        }.toList()
        var sum = 0
        var counter = 0
        for (l in list2) {
            if (sum == -1) {
                break
            }
            counter++
            sum += l
        }
        return counter
    }

    //B-DEL AFTER
// -> https://github.com/agrison/advent-of-code/blob/master/src/main/kotlin/me/grison/aoc/y2015/Day01.kt
    fun getToBasement2(file: String): Int {
        var sum = 0
        return File(file).readText().toList().map { if (it == '(') ++sum else --sum }.indexOf(-1) + 1
    }

    fun main() {
        println(getFloor(getList(file)))
        println(getFloor2(getList(file)))
        println(getToBasement(getList(file)))
        println(getToBasement2(file))
    }
