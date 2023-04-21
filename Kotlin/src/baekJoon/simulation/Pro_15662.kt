package baekJoon.simulation

import INPUT
import printMatrix
import java.io.FileInputStream

// Åé´Ï¹ÙÄû(2)
class Pro_15662 {

    private lateinit var arr: Array<Array<Int>>
    private lateinit var visit: Array<Boolean>
    private lateinit var dirs: Array<Int>
    private var t = 0

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        t = br.readLine().toInt()
        arr = Array(t) { arrayOf() }
        repeat(t) {
            arr[it] = br.readLine().map { itt -> itt - '0' }.toTypedArray()
        }
        val k = br.readLine().toInt()
        repeat(k) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            visit = Array(t) { false }
            dirs = Array(t) { 0 }
            dfs(a - 1, b == 1)
            dirs.forEachIndexed { index, i ->
                if(i == 1) {
                    rotate1(arr[index])
                } else if(i == -1) {
                    rotate2(arr[index])
                }
            }
        }
        var cnt = 0
        for(i in 0 until t) {
            if(arr[i][0] == 1) cnt++
        }
        println(cnt)
    }

    private fun rotate1(arr: Array<Int>) {
        var pre = arr.first()
        for(i in 1 until arr.size) {
            val temp = arr[i]
            arr[i] = pre
            pre = temp
        }
        arr[0] = pre
    }

    private fun rotate2(arr: Array<Int>) {
        var pre  = arr.last()
        for(i in arr.size - 2 downTo 0) {
            val temp = arr[i]
            arr[i] = pre
            pre = temp
        }
        arr[arr.size - 1] = pre
    }

    private fun dfs(cur: Int, dir: Boolean) {
        if(cur == -1 || cur == t) {
            return
        }
        visit[cur] = true
        dirs[cur] = if(dir) 1 else -1
        if(cur == 0) {
            if(!visit[cur + 1]) {
                if(arr[cur][2] != arr[cur + 1][6]) {
                    dfs(cur + 1, !dir)
                }
            }
        } else if(cur == t - 1) {
            if(!visit[cur - 1]) {
                if(arr[cur][6] != arr[cur - 1][2]) {
                    dfs(cur - 1, !dir)
                }
            }
        } else {
            if(!visit[cur - 1]) {
                if(arr[cur - 1][2] != arr[cur][6]) {
                    dfs(cur - 1, !dir)
                }
            }
            if(!visit[cur + 1]) {
                if(arr[cur + 1][6] != arr[cur][2]) {
                    dfs(cur + 1, !dir)
                }
            }
        }
    }
}

fun main() {
    Pro_15662().solution()
}