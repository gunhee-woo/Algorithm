package baekJoon.backTracking

import INPUT
import printMatrix
import java.io.FileInputStream

class ABCDE_13023 {

    private lateinit var arr: Array<MutableList<Int>>
    private lateinit var check: Array<Boolean>
    private var result = false

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        arr = Array(n) { mutableListOf() }
        repeat(m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            arr[a].add(b)
            arr[b].add(a)
        }
        for(i in 0 until n) {
            check = Array(n) { false }
            check[i] = true
            dfs(i, 0)
            if(result) break
        }
        if(result) println(1) else println(0)
    }

    private fun dfs(cur: Int, cnt: Int) {
        if(cnt >= 4) {
            result = true
            return
        }
        for(i in arr[cur]) {
            if(!check[i]) {
                check[i] = true
                dfs(i, cnt + 1)
                if(result) return
                check[i] = false
            }
        }
    }
}

fun main() {
    ABCDE_13023().solution()
}