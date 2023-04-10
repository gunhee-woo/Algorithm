import java.io.FileInputStream

class ChoiceNumber_2230 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(n) { 0 }
        repeat(n) {
            arr[it] = br.readLine().toInt()
        }
        arr.sort()
        var result = Int.MAX_VALUE
        if(n > 1) {
            var s = 0
            var e = 0
            while(true) {
                if(e == n) {
                    break
                } else if(s == e) {
                    e++
                } else if(arr[e] - arr[s] >= m) {
                    result = result.coerceAtMost(arr[e] - arr[s])
                    s++
                } else {
                    e++
                }
            }
        }
        if(result == Int.MAX_VALUE) result = 0
        println(result)
    }
}

fun main() {
    ChoiceNumber_2230().solution()
}