package year2015.day2

import java.io.File

const val file = "src/year2015/day2/input"

fun getList(file:String):List<Int>{
    return file.let { File(file).readText().splitToSequence("\n", "x") }
        .map { it.trim() }.map { it.toInt()}.toList()
}

//A-DEL BEFORE
fun totalSumOfWrappingPaper(list:List<Int>) : Int {
    val list2 = list.chunked(3).toList()

    var sum = 0

    for (sublist in list2){
        val l = sublist[0]
        val w = sublist[1]
        val h = sublist[2]

        val box = listOf(l*w,w*h,h*l)
        val boxTimes2 = box.sum()*2
        val extra = box.min()
        sum += boxTimes2+ extra

    }
    return sum
}

//A-DEL AFTER
//-> https://github.com/timakden/advent-of-code/blob/main/src/main/kotlin/ru/timakden/aoc/year2015/Day02.kt
fun totalSumOfWrappingPaper2(file:String):Int {
    val list = File(file).readLines().map {
        it.trim().split('x').map { s -> s.toInt() }.sorted() }

    return  list.sumOf { (l, w, h) -> val box = listOf(l * w, w * h, h * l)
        box.sum() * 2 + box.minOrNull()!! }
}

//B-DEL BEFORE
fun totalSumOfRibbon(list:List<Int>): Int {
    val list2 = list.map { it } .chunked(3).toList()

    var sum = 0
    for (subList in list2) {
        val l = subList[0]
        val w = subList[1]
        val h = subList[2]

        val listOfSides = listOf(l, h, w)
        val new = listOfSides.sortedDescending().drop(1)
        val wrap = new.sum() * 2
        val bow = l * h * w
        sum += wrap + bow

    }
    return sum
}
//B-DEL AFTER
//-> https://github.com/agrison/advent-of-code/blob/master/src/main/kotlin/me/grison/aoc/y2015/Day02.kt
fun totalSumOfRibbon2(file:String): Int {
    val list = File(file).readLines().map {
        it.trim().split('x').map { s -> s.toInt() }.sorted()
    }
    return list.sumOf{(l,w,h)-> val box = listOf( 2*l+2*w + l*w*h)
        box.sum()
    }


}


fun main() {
    println(totalSumOfWrappingPaper(getList(file)))
    println(totalSumOfWrappingPaper2(file))
    println(totalSumOfRibbon(getList(file)))
    println(totalSumOfRibbon2(file))
}