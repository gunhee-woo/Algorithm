package baekJoon.graph

import INPUT
import java.io.FileInputStream
import java.util.*
import kotlin.math.max

fun main() {
    System.setIn(FileInputStream(INPUT))
    var n = 0
    var m = 0
    val arr: Array<Array<Int>>
    val check: Array<Array<Boolean>>
    val ax = arrayOf(0, 0, -1, 1)
    val ay = arrayOf(-1, 1, 0, 0)
    System.`in`.bufferedReader().run {
        readLine().split(" ").also {
            n = it[0].toInt()
            m = it[1].toInt()
        }
        arr = Array(n) { Array(m) { 0 } }
        check = Array(n) { Array(m) { false } }
        repeat(n) {
//            arr[it] = readLine().split(" ").map { itt -> itt.toInt() }.toTypedArray()
            val str = readLine().split(" ")
            for(i in str.indices) {
                arr[it][i] = str[i].toInt()
            }
        }
    }
    var total = 0
    var max = 0
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(arr[i][j] == 1 && !check[i][j]) {
                total++
                check[i][j] = true
                var cnt = 1
                val q: Queue<Pair<Int, Int>> = LinkedList()
                q.add(i to j)
                while(q.isNotEmpty()) {
                    val cx = q.peek().first
                    val cy = q.peek().second
                    q.poll()
                    for(k in 0..3) {
                        val nx = cx + ax[k]
                        val ny = cy + ay[k]
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                        if(arr[nx][ny] == 1 && !check[nx][ny]) {
                            cnt++
                            q.add(nx to ny)
                            check[nx][ny] = true
                        }
                    }
                }
                max = max(max, cnt)
            }
        }
    }
    println(total)
    println(max)
}