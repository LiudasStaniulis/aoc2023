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
    var s = 0
    for (i in data){
        var c = 0
        val t = i.removeRange(0, i.indexOf(':') + 2).split('|')
        for (j in t[1].split(" ")){
            if(j in t[0].split(" ") && j.isNotEmpty()){
                c ++
            }
        }
        s += pow(2.0, c - 1.0).toInt()
    }
    println(s)
}

fun part2(data: Array<String>){
    var s = 0
    var arr = Array(data.size){1}
    for (i in data.indices){
        var c = 0
        val t = data[i].removeRange(0, data[i].indexOf(':') + 2).split('|')
        for (j in t[1].split(" ")){
            if(j in t[0].split(" ") && j.isNotEmpty()){
                c ++
            }
        }
        for (j in 1..c){
            if(data.size > j + i) {
                arr[j + i] += arr[i]
            }
        }
    }
    println(arr.reduce{sum, it -> sum + it})
}


fun main() {
    val lines = File("C:\\Users\\stani\\IdeaProjects\\ProjectEuler\\src\\main\\kotlin\\input").readLines().toTypedArray()
    part1(lines)
    part2(lines)
}
