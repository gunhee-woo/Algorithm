package baekJoon.graph.bfs

import java.io.FileInputStream
import java.util.*

class ExtendedGame_16920 {

    fun solution() {
        //System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, m, p) = br.readLine().split(" ").map { it.toInt() }
        val move = Array(p + 1) { 0 }
        br.readLine().split(" ").map { it.toInt() }.withIndex().forEach {
            move[it.index + 1] = it.value
        }
        val arr = Array(n) { Array(m) { "" } }
        val check = Array(n) { Array (m) { false } }
        val count = Array(p + 1) { 0 }
        val ax = arrayOf(-1, 1, 0, 0)
        val ay = arrayOf(0, 0, -1, 1)
        val qs: Array<Queue<Pair<Int, Int>>> = Array(p + 1) { LinkedList() }
        repeat(n) {
            val line = br.readLine()
            for(i in line.indices) {
                arr[it][i] = "${line[i]}"
                if(arr[it][i] != "." && arr[it][i] != "#") {
                    check[it][i] = true
                    val player = arr[it][i].toInt()
                    count[player]++
                    qs[player].add(it to i)
                }
            }
        }
        while (true) {
            for(player in 1..p) {
                val q = qs[player]
                var dist = move[player]
                while(q.isNotEmpty() && dist > 0) {
                    for(k in q.indices) {
                        val cx = q.peek().first
                        val cy = q.peek().second
                        //println("cx : $cx, cy : $cy, dist : $dist")
                        q.poll()
                        for(i in 0..3) {
                            val nx = cx + ax[i]
                            val ny = cy + ay[i]
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                            if(!check[nx][ny] && arr[nx][ny] == ".") {
                                check[nx][ny] = true
                                count[player]++
                                q.add(nx to ny)
                            }
                        }
                    }
                    dist--
                }
            }
            val b = qs.all { it.isEmpty() }
            if(b) break
        }
        for(i in 1..p) {
            print("${count[i]} ")
        }
    }
}

fun main() {
    ExtendedGame_16920().solution()
}