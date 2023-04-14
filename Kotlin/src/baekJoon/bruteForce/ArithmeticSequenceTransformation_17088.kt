import java.io.FileInputStream
import kotlin.math.abs
import kotlin.math.min

class ArithmeticSequenceTransformation_17088 {

//    private var n = 0
//    private var result = Int.MAX_VALUE
//
//    fun solution() {
//        System.setIn(FileInputStream(INPUT))
//        val br = System.`in`.bufferedReader()
//        n = br.readLine().toInt()
//        val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
//        if(n == 1) println(-1)
//        else {
//            dfs(0, arr, 0)
//            println(if(result == Int.MAX_VALUE) -1 else result)
//        }
//    }
//
//    private fun dfs(k: Int, arr: Array<Int>, cnt: Int) {
//        if(k == n) {
//            //arr.printMatrix()
//            if(predicate(arr)) {
//                result = min(result, cnt)
//                //println(result)
//            }
//            return
//        }
//        dfs(k + 1, arr.copyOf().also { it[k] = it[k] - 1 }, cnt + 1)
//        dfs(k + 1, arr.copyOf(), cnt)
//        dfs(k + 1, arr.copyOf().also { it[k] = it[k] + 1 }, cnt + 1)
//    }
//
//    private fun predicate(arr: Array<Int>): Boolean {
//        var s = 0
//        var e = 1
//        var gape = 0
//        var result = true
//        while(e < n) {
//            if(gape == 0) {
//                gape = abs(arr[s] - arr[e])
//                s++
//                e++
//                continue
//            }
//            if(abs(arr[s] - arr[e]) != gape) {
//                result = false
//                break
//            }
//            s++
//            e++
//        }
//        return result
//    }

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        if(n == 1) println(0)
        else {
            var result = Int.MAX_VALUE
            for(i in -1..1) {
                for(j in -1..1) {
                    val first = arr[0] + i
                    val second = arr[1] + j
                    val gape = abs(second - first)
                    var cnt = 0
                    if(first != arr[0]) cnt++
                    if(second != arr[1]) cnt++
                    var check = true
                    for(k in 2 until n) {
                        val a = arr[k] + i
                        val b = arr[k - 1] + j
                        if(a != arr[k]) cnt++
                        if(b != arr[k - 1]) cnt++
                        val g = abs(b - a)
                        println("$k, $a, $b, $g, $cnt")
                        if(gape != g) {
                            check = false
                            break
                        }
                    }
//                    println("cnt : $cnt, check : $check")
                    if(check) {
                       result = min(result, cnt)
                    }
                }
            }
            println(if(result == Int.MAX_VALUE) -1 else result)
        }
    }

}

fun main() {
    ArithmeticSequenceTransformation_17088().solution()
}