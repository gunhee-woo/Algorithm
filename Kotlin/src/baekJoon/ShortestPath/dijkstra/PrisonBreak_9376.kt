package baekJoon.ShortestPath.dijkstra

import INPUT
import java.io.FileInputStream
import java.util.*
import kotlin.math.min

class PrisonBreak_9376 {

    private var h = 0
    private var w = 0
    private val ax = arrayOf(-1, 1, 0, 0)
    private val ay = arrayOf(0, 0, -1, 1)
    private lateinit var map: Array<Array<String>>
    private lateinit var dp: Array<Array<Array<Int>>>
    private val INF = 987654321

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        var t = br.readLine().toInt()
        while(t-- > 0) {
            br.readLine().split(" ").map { it.toInt() }.also {
                h = it[0]
                w = it[1]
            }
            map = Array(h + 2) { Array(w + 2) { "" } }
            dp = Array(3) { Array(h + 2) { Array(w + 2) { INF } } }
            val start = mutableListOf<Triple<Int, Int, Int>>()
            repeat(h) { i ->
                val line = br.readLine().map { it.toString() }
                repeat(w) { j ->
                    map[i + 1][j + 1] = line[j]
                    if(line[j] == "$") {
                        start.add(Triple(i + 1, j + 1, 0)) // 죄수 1, 2에서 길을 찾을 때
                    }
                }
            }
            for(i in 0..h + 1) {
                map[i][0] = "."
                map[i][w + 1] = "."
            }
            for(i in 0..w + 1) {
                map[0][i] = "."
                map[h + 1][i] = "."
            }
            start.add(Triple(0, 0, 0)) // 밖에서 길을 찾을 때
            for(i in start.indices) {
                dijkstra(i, start[i])
            }
//            map.printMatrix()
//            dp.printMatrix()
//            for(i in 0 until 3) {
//                for(j in 0 until h + 2) {
//                    for(k in 0 until w + 2) {
//                        print("${if(dp[i][j][k] == INF) 9 else dp[i][j][k]} ")
//                    }
//                    println()
//                }
//                println()
//            }
            var result = Int.MAX_VALUE
            for(i in 1..h) {
                for(j in 1..w) {
                    if(map[i][j] == "*") continue
                    var sum = dp[0][i][j] + dp[1][i][j] + dp[2][i][j]
                    if(map[i][j] == "#") sum -= 2
                    if(sum >= 0) result = min(result, sum)
                }
            }
            println(result)
        }
    }

    private fun dijkstra(case: Int, start: Triple<Int, Int, Int>) {
        val pq = PriorityQueue<Triple<Int, Int, Int>> { o1, o2 ->
            o1.third - o2.third
        }
        dp[case][start.first][start.second] = 0
        pq.add(start)
        while(pq.isNotEmpty()) {
            val cx = pq.peek().first
            val cy = pq.peek().second
            val cc = pq.peek().third
            pq.poll()
            if(dp[case][cx][cy] < cc) continue
            for(i in 0..3) {
                val nx = cx + ax[i]
                val ny = cy + ay[i]
                if(nx < 0 || nx > h + 1 || ny < 0 || ny > w + 1 || map[nx][ny] == "*") continue
                if(map[nx][ny] == "#") {
                    if(dp[case][nx][ny] > cc + 1) {
                        dp[case][nx][ny] = cc + 1
                        pq.add(Triple(nx, ny, cc + 1))
                    }
                } else {
                    if(dp[case][nx][ny] > cc) {
                        dp[case][nx][ny] = cc
                        pq.add(Triple(nx, ny, cc))
                    }
                }
            }
        }
    }
}

fun main() {
    PrisonBreak_9376().solution()
}