import java.io.File
import java.util.Scanner
val input = Scanner(System.`in`)
fun booltoint(b: Boolean): Int{
    if(b){
        return 1
    }
    else{
        return 0
    }
}

fun part1(data: List<String>){
    var s = 0
    for (i in data){
        for (j in i){
            if(j.isDigit()){
                s += 10 * j.digitToInt()
                break
            }
        }
        for (j in i.reversed()){
            if(j.isDigit()) {
                s += j.digitToInt()
                break
            }
        }
    }
    println(s)
}

fun part2(data: List<String>){
    var s = 0;
    val words = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    for (i in data){
        for (j in i.indices){
            var found = false
            if(i[j].isDigit()){
                s += 10 * i[j].digitToInt()
                break
            }
            for (k in words.indices){
                if(words[k] in i.substring(0, j + 1)){
                    s += 10 * (k + 1)
                    found = true
                    break
                }
            }
            if (found){
                break
            }
        }
        for (j in i.indices.reversed()){
            var found = false
            if(i[j].isDigit()){
                s += i[j].digitToInt()
                break
            }
            for (k in words.indices){
                if(words[k] in i.substring(j, i.length)){
                    s += (k + 1)
                    found = true
                    break
                }
            }
            if (found){
                break
            }
        }
    }
    println(s)
}


fun main() {
    val lines = File("C:\\Users\\stani\\IdeaProjects\\ProjectEuler\\src\\main\\kotlin\\input").readLines()
    part1(lines)
    part2(lines)
}
