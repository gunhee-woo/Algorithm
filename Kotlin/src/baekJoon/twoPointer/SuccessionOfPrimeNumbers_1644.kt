package baekJoon.twoPointer

import INPUT
import printMatrix
import java.io.FileInputStream
import kotlin.math.sqrt

class SuccessionOfPrimeNumbers_1644 {

    private val MAX = 4000000
    private val check = Array(MAX + 1) { false }
    private val prime = Array(283146 + 1) { 0 }
    private var count = 0

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        setPrime()
        var s = 0
        var e = 0
        var sum = 0
        var result = 0
        while (e <= count) {
            if(sum == n) {
                result++
            } else if(sum < n) {
                sum += prime[e++]
                continue
            }
            sum -= prime[s++]
        }
        println(result)
    }

    private fun setPrime() {
        for(i in 2..sqrt(MAX.toDouble()).toInt()) {
            if(check[i]) continue
            var j = i + i
            while (j <= MAX) { // i의 배수는 소수가 될 수 없음
                check[j] = true
                j += i
            }
        }
        for(i in 2..MAX) {
            if(!check[i]) prime[count++] = i
        }
    }
}

fun main() {
    SuccessionOfPrimeNumbers_1644().solution()
}