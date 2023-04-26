package baekJoon.ShortestPath.dijkstra

import INPUT
import java.io.FileInputStream
import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

//class Pro_20183 {
//
//    private var n = 0
//    private var m = 0
//    private var a = 0
//    private var b = 0
//    private var c = 0L
//    private lateinit var arr: Array<MutableList<Pair<Int, Int>>>
//
//    fun solution() {
//        System.setIn(FileInputStream(INPUT))
//        val br = System.`in`.bufferedReader()
//        br.readLine().split(" ").also {
//            n = it[0].toInt()
//            m = it[1].toInt()
//            a = it[2].toInt()
//            b = it[3].toInt()
//            c = it[4].toLong()
//        }
//        arr = Array(n + 1) { mutableListOf() }
//        repeat(m) {
//            val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
//            arr[x].add(y to z)
//            arr[y].add(x to z)
//        }
//        var s = 1
//        var e = 1_000_000_000
//        var answer = Int.MAX_VALUE
//        while(s <= e) {
//            val mid = (s + e) / 2
//            if(dijkstra(mid, BooleanArray(n + 1))) {
//                answer = min(answer, mid)
//                e = mid - 1
//            } else {
//                s = mid + 1
//            }
//        }
//        println(if(answer == Int.MAX_VALUE) -1 else answer)
//    }
//
//    private fun dijkstra(search: Int, visited: BooleanArray):Boolean {
//        val pq = PriorityQueue<Triple<Int, Int, Int>> { o1, o2 ->
//            o1.third - o2.third
//        }
//        pq.add(Triple(a, 0, 0))
//        visited[a] = true
//        while(pq.isNotEmpty()) {
//            val cur = pq.peek().first
//            val cost = pq.peek().second
//            val maxCost = pq.peek().third
//            pq.poll()
//            for(i in arr[cur]) {
//                val next = i.first
//                val nextCost = cost + i.second
//                val nextMaxCost = max(maxCost, i.second)
//                if(visited[next]) continue
//                if(nextCost <= c && search >= nextMaxCost) {
//                    if(next == b) return true
//                    pq.add(Triple(next, nextCost, nextMaxCost))
//                    visited[next] = true
//                }
//            }
//        }
//        return false
//    }
//}

class Pro_20183 {

    private var n = 0
    private var m = 0
    private var a = 0
    private var b = 0
    private var c = 0L
    private lateinit var arr: Array<MutableList<Pair<Int, Int>>>
    private lateinit var dp: Array<Int> // 해당 노드에 대한 maxCost 최솟값

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").also {
            n = it[0].toInt()
            m = it[1].toInt()
            a = it[2].toInt()
            b = it[3].toInt()
            c = it[4].toLong()
        }
        arr = Array(n + 1) { mutableListOf() }
        repeat(m) {
            val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
            arr[x].add(y to z)
            arr[y].add(x to z)
        }
        dp = Array(n + 1) { 1000000001 }
        var s = 1
        var e = 1_000_000_000
        var answer = Int.MAX_VALUE
        while(s <= e) {
            val mid = (s + e) / 2
            if(dijkstra(mid)) {
                answer = min(answer, mid)
                e = mid - 1
            } else {
                s = mid + 1
            }
        }
        println(if(answer == Int.MAX_VALUE) -1 else answer)
    }

    private fun dijkstra(search: Int): Boolean {
        val pq = PriorityQueue<Triple<Int, Int, Int>> { o1, o2 ->
            o1.third - o2.third
        }
        pq.add(Triple(a, 0, 0))
        dp[a] = 0
        while(pq.isNotEmpty()) {
            val cur = pq.peek().first
            val cost = pq.peek().second
            val maxCost = pq.peek().third
            pq.poll()
            if(dp[cur] < maxCost) continue
            for(i in arr[cur]) {
                val next = i.first
                val nextCost = cost + i.second
                val nextMaxCost = max(maxCost, i.second)
                if(nextCost <= c && dp[next] > nextMaxCost) {
                    if(next == b) return true
                    pq.add(Triple(next, nextCost, nextMaxCost))
                    dp[next] = nextMaxCost
                }
            }
        }
        return false
    }
}

fun main() {
    Pro_20183().solution()
}