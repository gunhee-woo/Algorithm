package baekJoon.graph.bfs

import java.io.FileInputStream
import java.util.*
import kotlin.math.min

class MonkeyWantToHorse_1600 {

    private val ax = arrayOf(-1, 1, 0, 0)
    private val ay = arrayOf(0, 0, -1, 1)
    private val hx = arrayOf(-1, -2, -2, -1, 1, 2, 2, 1)
    private val hy = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)

    fun solution() {
        //System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val k = br.readLine().toInt()
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(h) { Array(w) { 0 } }
        repeat(h) { i ->
            arr[i] = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        }
        val check = Array(h) { Array(w) { Array(k + 1) { false } } }
        val q: Queue<Point> = LinkedList()
        q.add(Point(0, 0, k, 0))
        check[0][0][k] = true
        var min = Int.MAX_VALUE
        while(q.isNotEmpty()) {
            val cp = q.peek()
            if(cp.x == h - 1 && cp.y == w - 1) {
                min = min(min, cp.cnt)
                break
            }
            q.poll()
            for(i in 0..3) {
                val nx = cp.x + ax[i]
                val ny = cp.y + ay[i]
                if(nx < 0 || nx >= h || ny < 0 || ny >= w || arr[nx][ny] == 1) continue
                if(!check[nx][ny][cp.k]) {
                    check[nx][ny][cp.k] = true
                    q.add(Point(nx, ny, cp.k, cp.cnt + 1))
                }
            }
            if(cp.k > 0) {
                for(i in 0..7) {
                    val nx = cp.x + hx[i]
                    val ny = cp.y + hy[i]
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w || arr[nx][ny] == 1) continue
                    if(!check[nx][ny][cp.k - 1]) {
                        check[nx][ny][cp.k - 1] = true
                        q.add(Point(nx, ny, cp.k - 1, cp.cnt + 1))
                    }
                }
            }
        }
        if(min == Int.MAX_VALUE) println(-1)
        else println(min)
    }

    data class Point(val x: Int, val y: Int, val k: Int, val cnt: Int)
}

fun main() {
    MonkeyWantToHorse_1600().solution()
}