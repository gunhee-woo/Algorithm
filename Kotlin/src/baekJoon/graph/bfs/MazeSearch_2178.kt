package baekJoon.graph.bfs

import INPUT
import java.io.FileInputStream
import java.util.*

fun main() {
    System.setIn(FileInputStream(INPUT))
    var n = 0
    var m = 0
    val arr: Array<Array<Int>>
    val check: Array<Array<Boolean>>
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val ax = arrayOf(0, 0, -1 , 1)
    val ay = arrayOf(-1, 1, 0, 0)
    System.`in`.bufferedReader().run {
        readLine().split(" ").also {
            n = it[0].toInt()
            m = it[1].toInt()
        }
        arr = Array(n) { Array(m) { 0 } }
        check = Array(n) { Array(m) { false } }
        repeat(n) {
            arr[it] = readLine().map { itt -> itt - '0' }.toTypedArray()
//            val str = readLine()
//            for (i in str.indices) {
//                arr[it][i] = str[i] - '0'
//            }
        }
    }
    q.add(0 to 0)
    check[0][0] = true
    while(q.isNotEmpty()) {
        val cx = q.peek().first
        val cy = q.peek().second
        q.poll()
        for (i in 0..3) {
            val nx = cx + ax[i]
            val ny = cy + ay[i]
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if(!check[nx][ny] && arr[nx][ny] == 1) {
                check[nx][ny] = true
                q.add(nx to ny)
                arr[nx][ny] += arr[cx][cy]
            }
        }
    }
    println(arr[n - 1][m - 1])
}