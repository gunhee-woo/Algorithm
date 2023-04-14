import java.io.FileInputStream
import java.lang.Integer.max

class LeaveCompany2_15486 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        val arr = Array(n + 2) { 0 to 0}
        val d = Array(n + 2) { 0 }
        repeat(n) {
            val (t, p) = br.readLine().split(" ").map { itt -> itt.toInt() }
            arr[it + 1] = t to p
        }
        var result = 0
        for(i in 1..n + 1) {
            result = max(result, d[i])
            if(i + arr[i].first > n + 1) continue
            d[i + arr[i].first] = max(d[i + arr[i].first], result + arr[i].second)
        }
        println(result)
    }
}

fun main() {
    LeaveCompany2_15486().solution()
}