import java.io.FileInputStream
import java.lang.Integer.max

class LongestEvenConsecutiveSubsequence_22862 {

    // K번 원소를 삭제한 수열에서 연속된 짝수의 부분수열 => K개의 홀수를 포함한 부분수열
    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        var s = 0
        var e = 0
        var cnt = 0
        var result = -1
        while(true) {
            if(cnt > k) {
                if(arr[s] % 2 == 1) {
                    cnt--
                }
                s++
            } else if(e == n) {
                break
            } else {
                if(arr[e] % 2 == 1) {
                    cnt++
                }
                e++
                result = max(result, e - s - cnt)
            }
        }
        println(result)
    }
}

fun main() {
    LongestEvenConsecutiveSubsequence_22862().solution()
}