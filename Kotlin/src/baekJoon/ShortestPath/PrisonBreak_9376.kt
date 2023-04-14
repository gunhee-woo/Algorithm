package baekJoon.ShortestPath

import INPUT
import java.io.FileInputStream
import java.util.*

class PrisonBreak_9376 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        var t = br.readLine().toInt()
        while(t-- > 0) {
            val (h, w) = br.readLine().split(" ").map { it.toInt() }
            val map = Array(h) { Array(w) { "" } }
            val d = Array(h) { Array(w) { 0 } }
            val ax = arrayOf(-1, 1, 0, 0)
            val ay = arrayOf(0, 0, -1, 1)
            val start = mutableListOf<Pair<Int, Int>>()
            val prisoner = arrayListOf<Pair<Int, Int>>()
            var cnt = 0
            repeat(h) { i ->
                br.readLine().map { it.toString() }.forEachIndexed { j, c ->
                    map[i][j] = c
                    if(i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                        if(c != "*") {
                            start.add(i to j)
                            if(c == "$") {
                                cnt++
                            }
                        }
                    }
                    if(c == "$") {
                        prisoner.add(i to j)
                    }
                }
            }
            if(cnt == 2) { // 테두리에 죄인 모두 있을 경우
                println(0)
                continue
            }
            start.forEach {
                val q: Queue<Triple<Int, Int, Int>> = LinkedList()
                q.add(Triple(it.first, it.second, if(map[it.first][it.second] == "#") 1 else 0))
                while(q.isNotEmpty()) {
                    val cx = q.peek().first
                    val cy = q.peek().second
                    val cc = q.peek().third
                    q.poll()
                    if(map[cx][cy] == "$") {
                        cnt++
                        if(cnt == 2) continue
                    }
                    for(i in 0..3) {
                        val nx = cx + ax[i]
                        val ny = cy + ay[i]
                        if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == "*") continue
                        if(map[nx][ny] == "#") {

                        } else {
                            q.add(Triple(nx, ny, cc))
                        }
                    }
                }
            }
        }
    }
}

fun main() {
    PrisonBreak_9376().solution()
}