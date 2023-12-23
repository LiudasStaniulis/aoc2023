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

fun part1(data: Array<String>){
    var s = 0
    var lines = mutableListOf<List<List<String>>>()
    for (i in data.indices){
        var line = data[i].removeRange(0, data[i].indexOf(':') + 2).split("; ")
        var temp = mutableListOf<List<String>>()
        for (j in line){
            temp.add(j.split(", "))
        }
        lines.add(temp)
    }
    for (i in lines.indices){
        var valid = true
        for (j in lines[i]){
            for(k in j){
                val t = k.split(" ")
                if(t[1] == "red"){
                    if(t[0].toInt() > 12){
                        valid = false
                    }
                }
                if(t[1] == "green"){
                    if(t[0].toInt() > 13) {
                        valid = false
                    }
                }
                if(t[1] == "blue"){
                    if(t[0].toInt() > 14) {
                        valid = false
                    }
                }
            }
        }
        if (valid){
            s += i + 1
        }
    }
    println(s)
}

fun part2(data: Array<String>){
    var s = 0
    var lines = mutableListOf<List<List<String>>>()
    for (i in data.indices){
        var line = data[i].removeRange(0, data[i].indexOf(':') + 2).split("; ")
        var temp = mutableListOf<List<String>>()
        for (j in line){
            temp.add(j.split(", "))
        }
        lines.add(temp)
    }
    for (i in lines.indices){
        var red = 0
        var green = 0
        var blue = 0
        for (j in lines[i]){
            for(k in j){
                val t = k.split(" ")
                if(t[1] == "red"){
                    red = max(red, t[0].toInt())
                }
                if(t[1] == "green"){
                    green = max(green, t[0].toInt())
                }
                if(t[1] == "blue"){
                    blue = max(blue, t[0].toInt())
                }
            }
        }
        s += red * blue * green
    }
    println(s)
}


fun main() {
    val lines = File("C:\\Users\\stani\\IdeaProjects\\ProjectEuler\\src\\main\\kotlin\\input").readLines().toTypedArray()
    part1(lines)
    part2(lines)
}
