package baekJoon.dataStructure.heap

import INPUT
import java.io.FileInputStream
import java.util.*

fun main() {
    System.setIn(FileInputStream(INPUT))
    System.`in`.bufferedReader().run {
        val T = readLine().toInt()
        repeat(T) {
            val pq = PriorityQueue<Pair<Int, Boolean>>() // peek ���� �ּڰ� (��������)
            val pq2 = PriorityQueue<Pair<Int, Boolean>>()
        }
    }
}