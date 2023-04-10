package baekJoon.dataStructure.heap

import INPUT
import java.io.FileInputStream
import java.util.*
import kotlin.math.abs


fun main() {
    System.setIn(FileInputStream(INPUT))
    var N: Int
    val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        if(o1.first == o2.first) o1.second - o2.second else o1.first - o2.first
    }
//    val pq2 = PriorityQueue<Int> { a, b ->
//        val newA = abs(a)
//        val newB = abs(b)
//        when {
//            newA < newB -> -1
//            newA > newB -> 1
//            a < b -> -1
//            a > b -> 1
//            else -> 0
//        }
//    }
    System.`in`.bufferedReader().run {
        N = readLine().toInt()
        repeat(N) {
            val n = readLine().toInt()
            if(n == 0) {
                if(pq.isEmpty()) println(0)
                else println(pq.poll().second)
            } else {
                pq.add(abs(n) to n)
            }
        }
//        while(N-- > 0) {
//            val n = readLine().toInt()
//            if(n == 0) {
//                if(pq.isEmpty()) println(0)
//                else println(pq.poll().second)
//            } else {
//                pq.add(abs(n) to n)
//            }
//        }
    }
}
