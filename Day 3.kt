import java.io.File
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
    val moves = arrayOf(0 to 1, 0 to -1, 1 to 0, 1 to -1, 1 to 1, -1 to 0, -1 to -1, -1 to 1)
    for (i in data.indices){
        var cn = ""
        var valid = false
        for (j in data[i].indices){
            if(data[i][j].isDigit()){
                cn += data[i][j]
                for (k in moves){
                    var nx = j + k.first
                    var ny = i + k.second
                    if(validmove(nx, ny, data[i].length, data.size) && !data[ny][nx].isDigit() && data[ny][nx] != '.'){
                        valid = true
                    }
                }
            }
            else{
                if(cn.isNotEmpty() && valid){
                    s += cn.toInt()
                }
                cn = ""
                valid = false
            }
        }
        if(cn.isNotEmpty() && valid){
            s += cn.toInt()
        }
    }
    println(s)
}

fun part2(data: Array<String>){
    var s = 0
    var arr = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()
    val moves = arrayOf(0 to 1, 0 to -1, 1 to 0, 1 to -1, 1 to 1, -1 to 0, -1 to -1, -1 to 1)
    for (i in data.indices){
        var cn = ""
        var brr = mutableSetOf<Pair<Int, Int>>()
        for (j in data[i].indices){
            if(data[i][j].isDigit()){
                cn += data[i][j]
                for (k in moves){
                    var nx = j + k.first
                    var ny = i + k.second
                    if(validmove(nx, ny, data[i].length, data.size) && data[ny][nx] == '*'){
                        brr.add(nx to ny)
                    }
                }
            }
            else{
                if(cn.isNotEmpty()) {
                    for (k in brr) {
                        if(k !in arr.keys){
                            arr.put(k, mutableListOf<Int>())
                        }
                        arr[k]!!.add(cn.toInt())
                    }
                }
                brr.clear()
                cn = ""
            }
        }
        if(cn.isNotEmpty()) {
            for (k in brr) {
                if(k !in arr.keys){
                    arr.put(k, mutableListOf<Int>())
                }
                arr[k]!!.add(cn.toInt())
            }
        }
    }
    for (i in arr){
        if(i.component2().size == 2){
            s += i.component2()[0] * i.component2()[1]
        }
    }
    println(s)
}


fun main() {
    val lines = File("C:\\Users\\stani\\IdeaProjects\\ProjectEuler\\src\\main\\kotlin\\input").readLines().toTypedArray()
    part1(lines)
    part2(lines)
}
