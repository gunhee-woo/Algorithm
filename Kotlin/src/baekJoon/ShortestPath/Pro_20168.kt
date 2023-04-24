package baekJoon.ShortestPath

import INPUT
import java.io.FileInputStream
import java.util.PriorityQueue
import kotlin.math.max

class Pro_20168 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, m, a, b, c) = br.readLine().split(" ").map { it.toInt() }
        val arr: Array<MutableList<Pair<Int, Int>>> = Array(n + 1) { mutableListOf() }
        repeat(m) {
            val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
            arr[x].add(y to z)
            arr[y].add(x to z)
        }
        val INF = 987654321
        val dp = Array(n + 1) { INF } // maxCost ÀÇ ÃÖ¼Ú°ª
        // next, cost, maxCost
        val pq = PriorityQueue<Triple<Int, Long, Int>> { o1, o2 ->
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
                val nextCost = (cost + i.second).toInt()
                val nextMaxCost = max(maxCost, i.second)
                if(nextCost <= c && dp[next] > nextMaxCost) {
                    dp[next] = nextMaxCost
                    pq.add(Triple(next, nextCost.toLong(), nextMaxCost))
                }
            }
        }
        println(if(dp[b] == INF) -1 else dp[b])
    }
}

fun main() {
    Pro_20168().solution()
}