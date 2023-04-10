package baekJoon.dp

import INPUT
import printMatrix
import java.io.FileInputStream
import java.lang.StringBuilder
import java.util.*
import kotlin.math.max

class LongestIncreasingSubsequence4_14002 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        val d = Array(n) { 0 }
        val ix = Array(n) { -1 }
        for(i in 0 until n) {
            d[i] = 1
            for(j in 0 until i) {
                if(arr[i] > arr[j] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1
                    ix[i] = j
                }
            }
        }
        var start = 0
        var max = -1
        var cnt = 0
        for(i in 0 until n) {
            if(d[i] > max) {
                max = d[i]
                start = i
                cnt++
            }
        }
        val sb = StringBuilder()
        while(start != -1) {
            sb.insert(0, "${arr[start]} ")
            start = ix[start]
        }
        println(cnt)
        println(sb)
    }
}

fun main() {
    LongestIncreasingSubsequence4_14002().solution()
}