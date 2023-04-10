package baekJoon.graph.bfs

import INPUT
import java.io.FileInputStream
import java.util.*

fun main() {
    System.setIn(FileInputStream(INPUT))
    val br = System.`in`.bufferedReader()
    val ax = arrayOf(0, 0, -1, 1)
    val ay = arrayOf(-1, 1, 0, 0)
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { Array(m) { 0 } }
    val q: Queue<Pair<Int, Int>> = LinkedList()
    var cnt = 0
    repeat(n) {
        br.readLine().split(" ").withIndex().forEach { itt ->
            arr[it][itt.index] = itt.value.toInt()
            if(arr[it][itt.index] == 1) {
                q.add(it to itt.index)
            }
            if(arr[it][itt.index] == 0) cnt++
        }
    }
    if(cnt == 0) {
        println(0)
        return
    }
    var max = 1
    while(q.isNotEmpty()) {
        val cx = q.peek().first
        val cy = q.peek().second
        q.poll()
        for(i in 0..3) {
            val nx = cx + ax[i]
            val ny = cy + ay[i]
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if(arr[nx][ny] == 0) {
                arr[nx][ny] = arr[cx][cy] + 1
                max = arr[nx][ny].coerceAtLeast(max) // kotlin ½Ä max ÇÔ¼ö
                cnt--
                q.add(nx to ny)
            }
        }
    }
    if(cnt != 0) println(-1)
    else println(max - 1)
}