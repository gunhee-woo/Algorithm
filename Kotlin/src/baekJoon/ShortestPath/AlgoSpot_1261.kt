package baekJoon.ShortestPath

import INPUT
import printMatrix
import java.io.FileInputStream
import java.util.*

class AlgoSpot_1261 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (m, n) = br.readLine().split(" ").map { it.toInt() }
        val map = Array(n) { Array(m) { 0 } }
        repeat(n) {
            map[it] = br.readLine().map { itt -> itt.digitToInt() }.toTypedArray()
        }
        val d = Array(n) { Array(m) { Int.MAX_VALUE } }
        d[0][0] = 0
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        q.add(Triple(0, 0, 0))
        val ax = arrayOf(-1, 1, 0, 0)
        val ay = arrayOf(0, 0, -1, 1)
        while(q.isNotEmpty()) {
            val cx = q.peek().first
            val cy = q.peek().second
            val cc = q.peek().third
            q.poll()
            if(cx == n - 1 && cy == m - 1) {
                continue
            }
            for(i in 0..3) {
                val nx = cx + ax[i]
                val ny = cy + ay[i]
                var nc = cc
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                if(map[nx][ny] == 1) {
                    nc = cc + 1
                    if(d[nx][ny] > nc) {
                        d[nx][ny] = nc
                        q.add(Triple(nx, ny, nc))
                    }
                } else {
                    if(d[nx][ny] > nc) {
                        d[nx][ny] = nc
                        q.add(Triple(nx, ny, nc))
                    }
                }
            }
        }
        println(d[n - 1][m - 1])
    }
}

fun main() {
    AlgoSpot_1261().solution()
}