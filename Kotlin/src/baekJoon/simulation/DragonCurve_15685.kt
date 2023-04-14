package baekJoon.simulation

import INPUT
import printMatrix
import java.io.FileInputStream
import java.util.*

class DragonCurve_15685 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        val check = Array(101) { Array(101) { false } }
        val dx = arrayOf(1, 0, -1, 0)
        val dy = arrayOf(0, -1, 0, 1)
        repeat(n) {
            val (x, y, d, g) = br.readLine().split(" ").map { it.toInt() }
            val list = mutableListOf<Int>().apply { add(d) }
            repeat(g) {
                val stk = Stack<Int>().apply { addAll(list) }
                while(stk.isNotEmpty()) {
                    val temp = stk.pop() + 1
                    list.add(if(temp == 4) 0 else temp)
                }
            }
            check[x][y] = true
            var cx = x
            var cy = y
            list.forEach { i ->
                val nx = cx + dx[i]
                val ny = cy + dy[i]
                if(nx in 0..100 && ny in 0..100) {
                    check[nx][ny] = true
                    cx = nx
                    cy = ny
                }
            }
        }
        var count = 0
        for(i in 1..100) {
            for(j in 1..100) {
                if(check[i - 1][j - 1] && check[i - 1][j] && check[i][j - 1] && check[i][j]) {
                    count++
                }
            }
        }
        println(count)
    }
}

fun main() {
    DragonCurve_15685().solution()
}