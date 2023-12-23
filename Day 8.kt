import java.io.File
import java.util.Scanner
val input = Scanner(System.`in`)

fun booltoint(b: Boolean): Int{
    if(b) {
        return 1
    }
    else{
        return 0
    }
}
fun part1(data: MutableList<List<String>>, instr: String){
    val arr = mutableMapOf<String, List<String>>()
    for (i in data){
        arr[i[0]] = listOf(i[1], i[2])
    }
    var cur = "AAA"
    val end = "ZZZ"
    var step = 0
    val len = instr.length
    while (cur != end){
        cur = arr[cur]!![booltoint(instr[step % len] == 'R')]
        step ++
    }
    println(step)
}

fun gcd(a: Long, b: Long): Long{
    if(a == 0L){
        return b
    }
    return gcd(b % a, a)
}

fun lcm(brr: MutableMap<Int, Int>): Long{
    var ans = 1L
    for (i in brr.values){
        ans = ans * i / gcd(ans, i.toLong())
    }
    return ans
}

fun part2(data: MutableList<List<String>>, instr: String){
    val arr = mutableMapOf<String, List<String>>()
    val take = mutableListOf<String>()
    val brr = mutableMapOf<Int, Int>()
    for (i in data){
        arr[i[0]] = listOf(i[1], i[2])
        if(i[0].last() == 'A'){
            take.add(i[0])
        }
    }
    var step = 0
    val len = instr.length
    while(brr.size != take.size){
        step ++
        for(i in take.indices){
            take[i] = arr[take[i]]!![booltoint(instr[(step - 1) % len] == 'R')]
            if (take[i].last() == 'Z'){
                brr[i] = step
            }
        }
    }
    println(lcm(brr))
}

fun main() {
    val lines = File("input").readLines()
    val data = mutableListOf<List<String>>()
    for (i in lines){
        val t = i.replace(" = (", " ").replace(",", "").replace(")", "").split(" ")
        data.add(t)
    }
    val instr = data.first().joinToString()
    data.removeFirst()
    data.removeFirst()
    part1(data, instr)
    part2(data, instr)
}
