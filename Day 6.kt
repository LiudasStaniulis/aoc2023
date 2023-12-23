import java.io.File
import java.lang.Math.pow
import java.util.Scanner
import kotlin.math.max

val input = Scanner(System.`in`)
fun booltoint(b: Boolean): Int{
    if(b){
        return 1
    }
    else{
        return 0
    }
}

fun validmove(x: Int, y: Int, X: Int, Y: Int):Boolean{
    return (x >= 0 && y >= 0 && x < X && y < Y)
}

fun part1(data: Array<String>){
    var s = 1
    var time = data[0].filterIndexed{id, y -> if(id > 0) y != data[0][id - 1] else true}.removeRange(0, data[0].indexOf(':') + 1).removePrefix(" ").split(" ")
    var rec = data[1].filterIndexed{id, y -> if(id > 0) y != data[0][id - 1] else true}.removeRange(0, data[1].indexOf(':') + 1).removePrefix(" ").split(" ")
    for (i in 0 ..< time.size){
        var x = 0
        for (j in 1 .. time[i].toInt()){
            if ((time[i].toInt() - j) * j > rec[i].toInt()){
                x += 1
            }
        }
        s *= x
    }
    println(s)
}

fun part2(data: Array<String>){
    var s = 1
    var time = data[0].removeRange(0, data[0].indexOf(':') + 1).filterIndexed{id, y -> y != ' '}.split(" ")
    var rec = data[1].removeRange(0, data[1].indexOf(':') + 1).filterIndexed{id, y -> y != ' '}.split(" ")
    for (i in 0 ..< time.size){
        var x = 0
        for (j in 1 .. time[i].toLong()){
            if ((time[i].toLong() - j) * j > rec[i].toLong()){
                x += 1
            }
        }
        s *= x
    }
    println(s)
}


fun main() {
    val lines = File("C:\\Users\\stani\\IdeaProjects\\ProjectEuler\\src\\main\\kotlin\\input").readLines().toTypedArray()
    part1(lines)
    part2(lines)
}
