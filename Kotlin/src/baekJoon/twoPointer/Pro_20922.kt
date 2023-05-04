package baekJoon.twoPointer

import INPUT
import printList
import java.io.FileInputStream
import kotlin.math.max

class Pro_20922 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }
        val cnt = Array(100001) { 0 }
        var result = 1
        var s = 0
        var e = 0
//        arr.printList()
        while (e < n) {
            if(cnt[arr[e]] != k) {
                cnt[arr[e++]]++
            } else {
                cnt[arr[s++]]--
            }
            result = max(result, e - s)
        }
        println(result)
    }
}

fun main() {
    Pro_20922().solution()
}