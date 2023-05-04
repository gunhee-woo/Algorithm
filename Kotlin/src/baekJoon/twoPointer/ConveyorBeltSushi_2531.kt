package baekJoon.twoPointer

import INPUT
import printList
import printMatrix
import java.io.FileInputStream
import kotlin.math.max

class ConveyorBeltSushi_2531 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(n) { 0 }
        repeat(n) {
            arr[it] = br.readLine().toInt()
        }
//        arr.printMatrix()
        var result = 0
        var s = 0
        var e = 0
        val list = ArrayList<Int>()
        while (s < n) {
            if(list.size < k) {
                if(e == n) {
                    e = 0
                }
                list.add(arr[e++])
            } else if(list.size == k) {
                var cnt = list.distinct().size
//                list.printList()
                if(!list.contains(c)) cnt++
//                println("cnt : $cnt")
                result = max(result, cnt)
                list.remove(arr[s++])
            }
        }
        println(result)
    }
}

fun main() {
    ConveyorBeltSushi_2531().solution()
}