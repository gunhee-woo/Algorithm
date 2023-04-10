package baekJoon.dataStructure.heap

import INPUT
import java.io.FileInputStream
import java.util.*

fun main() {
    System.setIn(FileInputStream(INPUT))
    System.`in`.bufferedReader().run {
        val T = readLine().toInt()
        repeat(T) {
            val pq = PriorityQueue<Pair<Int, Boolean>>() // peek 값이 최솟값 (오름차순)
            val pq2 = PriorityQueue<Pair<Int, Boolean>>()
        }
    }
}