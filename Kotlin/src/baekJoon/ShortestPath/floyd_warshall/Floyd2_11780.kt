package baekJoon.ShortestPath.floyd_warshall

import INPUT
import printMatrix
import java.io.FileInputStream
import java.lang.StringBuilder
import kotlin.math.min

class Floyd2_11780 {

    private var n = 0
    private var m = 0
    private lateinit var dp: Array<Array<Int>>
    private lateinit var path: Array<Array<ArrayList<Int>>>
    private val INF = 987654321

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        m = br.readLine().toInt()
        dp = Array(n + 1) { Array(n + 1) { INF } }
        for(i in 1..n) {
            for(j in 1..n) {
                if(i == j) dp[i][j] = 0
            }
        }
        path = Array(n + 1) { Array(n + 1) { arrayListOf() } }
        repeat(m) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            dp[a][b] = min(dp[a][b], c) // 같은 경로의 값이 입력될 수 있으므로
        }
        for(k in 1..n) {
            for(i in 1..n) {
                for(j in 1..n) {
                    if(i == j) continue
                    if(dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j]
                        path[i][j].clear()
                        path[i][j].addAll(path[i][k])
                        path[i][j].add(k)
                        path[i][j].addAll(path[k][j])
                    }
                }
            }
        }
        for(i in 1..n) {
            for(j in 1..n) {
                print("${if(dp[i][j] == INF) 0 else dp[i][j]} ")
            }
            println()
        }
        for(k in (1 * n)until(n * n) + n) {
            val i = k / n
            val j = k % n + 1
            if(i == j) println(0)
            else {
                if(path[i][j].isEmpty()) {
                    println("2 $i $j")
                } else {
                    val sb = StringBuilder("${2 + path[i][j].size} $i ")
                    for(v in path[i][j]) {
                        sb.append("$v ")
                    }
                    sb.append("$j")
                    println(sb.toString())
                }
            }
        }
    }
}

fun main() {
    Floyd2_11780().solution()
}