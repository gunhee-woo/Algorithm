package baekJoon.graph.bfs

import INPUT
import printMatrix
import java.io.FileInputStream
import java.lang.StringBuilder
import java.util.*

fun main() {
    System.setIn(FileInputStream(INPUT))
    val ax = arrayOf(-1, 1, 0, 0, 0, 0)
    val ay = arrayOf(0, 0, -1, 1, 0, 0)
    val az = arrayOf(0, 0, 0, 0, -1, 1)
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    while (true) {
        val (l, r, c) = br.readLine().split(" ").map { it.toInt() }
        if(l == 0 && r == 0 && c == 0) {
            println(sb.toString())
            return
        }
        val visited = Array(l) { Array(r) { Array(c) { false } } }
        val arr = Array(l) { Array(r) { Array(c) { "" } } }
        var start = Quad(0, 0, 0, 0)
        repeat(l) { ll ->
            repeat(r) { rr ->
                val line = br.readLine()
                for(i in line.indices) {
                    if(line[i].toString() == "S") {
                        start = Quad(ll, rr, i, 0)
                    }
                    arr[ll][rr][i] = line[i].toString()
                }
            }
            br.readLine()
        }
        var find = false
        val q: Queue<Quad> = LinkedList()
        q.add(start)
        visited[start.z][start.x][start.y] = true
        while(q.isNotEmpty()) {
            val cx = q.peek().x
            val cy = q.peek().y
            val cz = q.peek().z
            val ct = q.peek().time
            q.poll()
            if(arr[cz][cx][cy] == "E") {
                sb.append("Escaped in $ct minute(s).").append("\n")
                find = true
                break
            }
            for(i in 0..5) {
                val nx = cx + ax[i]
                val ny = cy + ay[i]
                val nz = cz + az[i]
                val nt = ct + 1
                if(nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l) continue
                if(!visited[nz][nx][ny] && arr[nz][nx][ny] != "#") {
                    visited[nz][nx][ny] = true
                    q.add(Quad(nz, nx, ny, nt))
                }
            }
        }
        if(!find) sb.append("Trapped!").append("\n")
    }
}

data class Quad(val z: Int, val x: Int, val y: Int, val time: Int)