package year2019.day1

import java.io.File
import kotlin.math.floor

const val file = "src/year2019/day1/input"

fun getList(file:String):List<Double>{
    return file.let { File(file).readLines().map { it.toDoubleOrNull()!! }.toList()}
}

fun calcTotalFuel(list:List<Double>):Double{
    list.map { it }.toList()

    var sum = 0.0
    for (i in list){
        sum += floor(i/3)-2
    }
    return sum

}

//A-DEL AFTER
// -> https://www.reddit.com/r/adventofcode/comments/e4axxe/2019_day_1_solutions/
fun calcTotalFuel2(list:List<Double>):Double{
    return list.sumOf { floor(it.div(3.0) - 2) }
}

//B-DEL BEFORE
fun calcTotalFuelRequirements(list:List<Double>):Double{
    list.map { it }.toList()

    var fuel = 0.0
    var sum = 0.0
    for (i in list){
        fuel = floor(i/3.0)-2
        while (floor(fuel/3)-2>0){
            sum+=fuel
            fuel = floor(fuel/3)-2
            if(fuel<0){
                fuel=0.0
            }
        }
        sum+=fuel

    }
    return sum
}

//B-DEL AFTER
// -> https://todd.ginsberg.com/post/advent-of-code/2019/day1/
fun calcTotalFuelRequirements2(list:List<Double>): Double{
    list.map { it }.toList()
    return list.sumOf { calcFuelByLine(it) }
}

fun calcFuelByLine(line:Double) : Double {
    val fuel = floor(line/3)-2
    return if (fuel<=0){
        0.0
    }
    else {
        fuel + calcFuelByLine(fuel)
    }
}


fun main() {
    println(calcTotalFuel(getList(file)))
    println(calcTotalFuel2(getList(file)))
    println(calcTotalFuelRequirements(getList(file)))
    println(calcTotalFuelRequirements2(getList(file)))

}