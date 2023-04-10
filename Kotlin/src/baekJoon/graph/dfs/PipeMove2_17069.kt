package baekJoon.graph.dfs

import INPUT
import java.io.FileInputStream

class PipeMove2_17069 {

    private lateinit var arr: Array<Array<Int>>
    private var n = 0
    private lateinit var dp: Array<Array<Array<Long>>>

    // 0 가로, 1 세로, 2 대각선
    private val dx = Array(3) { arrayOf(0) }.also {
        it[0] = arrayOf(0, 1)
        it[1] = arrayOf(1, 1)
        it[2] = arrayOf(0, 1, 1)
    }
    private val dy = Array(3) { arrayOf(0) }.also {
        it[0] = arrayOf(1, 1)
        it[1] = arrayOf(0, 1)
        it[2] = arrayOf(1, 0, 1)
    }
    private val dd = Array(3) { arrayOf(0) }.also {
        it[0] = arrayOf(0, 2)
        it[1] = arrayOf(1, 2)
        it[2] = arrayOf(0, 1, 2)
    }

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        arr = Array(n) { Array(n) { 0 } }
        dp = Array(n) { Array(n) { Array(3) { 0 } } }
        repeat(n) {
            arr[it] = br.readLine().split(" ").map { itt -> itt.toInt() }.toTypedArray()
        }
        dp[0][1][0] = 1
        for(j in 2 until n) {
            for(i in 0 until n) {
                if(arr[i][j] == 1) continue
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
                if(i > 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
                    if(arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
                    }
                }
            }
        }
        println(dp[n - 1][n - 1].sum())
    }

    fun solution2() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        arr = Array(n) { Array(n) { 0 } }
        dp = Array(n) { Array(n) { Array(3) { 0 } } }
        repeat(n) {
            arr[it] = br.readLine().split(" ").map { itt -> itt.toInt() }.toTypedArray()
        }
        println(dfs2(0, 1, 0))
    }

    private fun dfs2(x: Int, y: Int, d: Int): Long {
        if(dp[x][y][d] > 0) return dp[x][y][d]
        if(x == n - 1 && y == n - 1) return 1
        for(i in dx[d].indices) {
            val nx = x + dx[d][i]
            val ny = y + dy[d][i]
            val nd = dd[d][i]
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 1) continue
            if(nd == 2) {
                if(arr[x + 1][y] == 1 || arr[x][y + 1] == 1) continue
            }
            dp[x][y][d] += dfs2(nx, ny, nd)
        }
        return dp[x][y][d]
    }
}

fun main() {
    PipeMove2_17069().solution2()
}