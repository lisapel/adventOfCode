package year2018.day1
import java.io.File

const val file = "src/year2018/day1/input"

fun getList(file:String): List <Int>{
    return file.let { File(file).readLines().map { it.toIntOrNull() }
    }.filterNotNull().toList()
}

//A-DEL BEFORE
fun calcFrequency(list:List<Int>) : Int{
    return list.sum()
}

//A-DEL AFTER
// -> https://www.reddit.com/r/adventofcode/comments/a20646/2018_day_1_solutions/
fun calcFrequency2(list:List<Int>):String{
    return list.sum().toString()
}

//B-DEL BEFORE
fun findFrequencyThatHitsTwice(list:List<Int>): Int {
    val setList = mutableSetOf<Int>()
    var sum = 0

    while (true) {
        for (i in list) {
            sum += i
            if (setList.contains(sum)) {
                return sum
            }
            setList += sum
        }
    }
}

//B-DEL AFTER
// -> https://www.reddit.com/r/adventofcode/comments/a20646/2018_day_1_solutions/
fun findFrequencyThatHitsTwice2(list:List<Int>):Int{
    val setList = mutableSetOf<Int>()
    var sum = 0

    while (true) {
        for (i in list) {
            sum += i
            if (!setList.add(sum)) return sum
            else setList.add(sum)
        }
    }
}

fun main() {
    println(calcFrequency(getList(file)))
    println(calcFrequency2(getList(file)))
    println(findFrequencyThatHitsTwice(getList(file)))
    println(findFrequencyThatHitsTwice2(getList(file)))
}