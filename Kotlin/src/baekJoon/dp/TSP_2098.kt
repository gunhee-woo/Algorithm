package baekJoon.dp

import INPUT
import printMatrix
import java.io.FileInputStream
import kotlin.math.min

class TSP_2098 {

    private var n = 0
    private var END = 0
    private val INF = 987654321
    private var cost = Array(16) { Array(16) { 0 } }
    private var d = Array(16) { Array(1 shl 16) { 0 } }

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        END = (1 shl n) - 1
        repeat(n) { i ->
            val line = br.readLine().split(" ").map { it.toInt() }
            for(j in line.indices) {
                cost[i][j] = line[j]
            }
        }
        println(dfs(0, 1))
    }

    private fun dfs(node: Int, path: Int): Int {
        if(path == END) { // 모든 노드들 방문했는데
            if(cost[node][0] != 0) { // 원래 노드로 돌아오는 경로가 존재하면
                return cost[node][0]
            }
            return INF // 원래 노드로 돌아오는 경로가 존재하지 않을 때
        }
        if(d[node][path] != 0) return d[node][path] // 이전에 계산한 값이 존재하면 그대로 사용 (메모이제이션)
        d[node][path] = INF
        for(i in 0 until n) {
            if(cost[node][i] == 0) continue // 다음 노드로 가는 경로가 없음
            if(path and (1 shl i) != 0) continue // 이미 방문한 노드일 경우
            d[node][path] = min(d[node][path], cost[node][i] + dfs(i, path or (1 shl i)))
        }
        return d[node][path]
    }
}

fun main() {
    TSP_2098().solution()
}