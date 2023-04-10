package baekJoon.graph.bfs

import INPUT
import java.io.FileInputStream
import java.util.*

class HideAndSeek4_13913 {
    private val MAX = 100001
    private lateinit var check: Array<Boolean>
    private lateinit var arr: Array<Int>

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        check = Array(MAX) { false }
        arr = Array(MAX) { -1 }
        val q = PriorityQueue<Pair<Int, Int>> { a, b ->
            a.second - b.second
        }
        q.add(n to 0)
        check[n] = true
        while(q.isNotEmpty()) {
            val cx = q.peek().first
            val cc = q.peek().second
            q.poll()
            if(cx == k) {
                println(cc)
                var ix = cx
                val path = mutableListOf<Int>()
                while(ix != n) {
                    path.add(ix)
                    ix = arr[ix]
                }
                path.add(n)
                for(i in path.reversed()) {
                    print("$i ")
                }
                return
            }
            if(cx * 2 < MAX && !check[cx * 2]) {
                if(arr[cx * 2] == -1)
                    arr[cx * 2] = cx
                q.add(cx * 2 to cc + 1)
                check[cx * 2] = true
            }
            if(cx + 1 < MAX && !check[cx + 1]) {
                if(arr[cx + 1] == -1)
                    arr[cx + 1] = cx
                q.add(cx + 1 to cc + 1)
                check[cx + 1] = true
            }
            if(cx - 1 >= 0 && !check[cx - 1]) {
                if(arr[cx - 1] == -1)
                    arr[cx - 1] = cx
                q.add(cx - 1 to cc + 1)
                check[cx - 1] = true
            }
        }
    }
}

fun main() {
    HideAndSeek4_13913().solution()
}