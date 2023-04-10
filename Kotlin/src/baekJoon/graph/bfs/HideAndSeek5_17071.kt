package baekJoon.graph.bfs

import INPUT
import java.io.FileInputStream
import java.util.*

class HideAndSeek5_17071 {

    private val MAX = 500001
    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(n to 0)
        var tx = 0
        val d = Array(MAX) { 0 }
        d[tx] = k
        while(q.isNotEmpty()) {
            val cx = q.peek().first
            val cc = q.peek().second
            q.poll()
            if(d[tx] == cx) {
                print(cc)
                return
            }
            if(tx != cc) {
                tx = cc
            }
            if(cx * 2 < MAX) {
                q.add(cx * 2 to cc + 1)
            }
            if(cx + 1 < MAX) {
                q.add(cx + 1 to cc + 1)
            }
            if(cx - 1 >= 0) {
                q.add(cx - 1 to cc + 1)
            }
            if(tx != 0)
                d[tx] = d[tx - 1] + tx
        }
    }
}

fun main() {

}