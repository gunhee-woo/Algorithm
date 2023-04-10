package baekJoon.graph.bfs

import INPUT
import java.io.FileInputStream
import java.util.*

fun main() {
    System.setIn(FileInputStream(INPUT))
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val ax = arrayOf(-1, -2, -2, -1, 1, 2, 2, 1)
    val ay = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    repeat(t) {
        val n = br.readLine().toInt()
        val start = br.readLine().split(" ").let { it[0].toInt() to it[1].toInt() }
        val end = br.readLine().split(" ").let { it[0].toInt() to it[1].toInt() }
        val check = Array(n) { Array(n) { false } }
        if(start.first == end.first && start.second == end.second) {
            println(0)
        } else {
            var b = false
            val q: Queue<Pair<Pair<Int, Int>, Int>> = LinkedList()
            q.add(start to 0)
            check[start.first][start.second] = true
            while(q.isNotEmpty()) {
                val cx = q.peek().first.first
                val cy = q.peek().first.second
                val cc = q.peek().second
                q.poll()
                for(i in 0..7) {
                    val nx = cx + ax[i]
                    val ny = cy + ay[i]
                    val nc = cc + 1
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue
                    if(!check[nx][ny]) {
                        if(nx == end.first && ny == end.second) {
                            b = true
                            println(nc)
                            break
                        } else {
                            q.add((nx to ny) to nc)
                            check[nx][ny] = true
                        }
                    }
                }
                if(b) break
            }
        }
    }
}