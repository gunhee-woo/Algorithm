package baekJoon.graph.dfs_bfs

import INPUT
import java.io.FileInputStream
import java.util.*

/**
 * *** BFS는 큐에서 뺀 다음이 아닌, 큐에 넣을 때 방문 체크를 해야 중복 방문이 일어나지 않는다 => 메모리 낭비를 줄일 수 있음 ***
 */

class RedGreenColorWeakness_10026 {
    var n: Int = 0
    lateinit var arr: Array<Array<String>>
    lateinit var check: Array<Array<Boolean>>
    private val ax = arrayOf(-1, 1, 0, 0)
    private val ay = arrayOf(0, 0, -1, 1)

    fun main() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        arr = Array(n) { Array(n) { "" } }
        repeat(n) {
            arr[it] = br.readLine().map { itt -> itt.toString() }.toTypedArray()
        }
//    val r1 = bfs(false)
//    val r2 = bfs(true)
        val r1 = solution(false)
        val r2 = solution(true)
        println("$r1 $r2")
    }

    fun bfs(b: Boolean): Int {
        var cnt = 0
        check = Array(n) { Array(n) { false } }
        val q: Queue<Pair<Int, Int>> = LinkedList()
        for(i in 0 until n) {
            for(j in 0 until n) {
                if(!check[i][j]) {
//                check.printMatrix()
                    cnt++
                    q.add(i to  j)
                    check[i][j] = true
                    while(q.isNotEmpty()) {
                        val cx = q.peek().first
                        val cy = q.peek().second
                        val cv = arr[cx][cy]
                        q.poll()
                        for(k in 0..3) {
                            val nx = cx + ax[k]
                            val ny = cy + ay[k]
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue
                            val nv = arr[nx][ny]
                            if(!check[nx][ny]) {
                                if(b) { // 적록색약인 경우
                                    when(cv) {
                                        "R", "G" -> if(nv != "B") {
                                            q.add(nx to ny)
                                            check[nx][ny] = true
                                        }
                                        "B" -> if(nv == "B") {
                                            q.add(nx to ny)
                                            check[nx][ny] = true
                                        }
                                    }
                                } else {
                                    when(cv) {
                                        "R" -> if(nv == "R") {
                                            q.add(nx to ny)
                                            check[nx][ny] = true
                                        }
                                        "G" -> if(nv == "G") {
                                            q.add(nx to ny)
                                            check[nx][ny] = true
                                        }
                                        "B" -> if(nv == "B") {
                                            q.add(nx to ny)
                                            check[nx][ny] = true
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return cnt
    }

    private fun solution(b: Boolean): Int {
        var cnt = 0
        check = Array(n) { Array(n) { false } }
        for(i in 0 until n) {
            for(j in 0 until n) {
                if(!check[i][j]) {
                    cnt++
                    dfs(i, j, b)
                }
            }
        }
        return cnt
    }

    private fun dfs(i: Int, j: Int, b: Boolean) {
        check[i][j] = true
        val cv = arr[i][j]
        for(k in 0..3) {
            val nx = i + ax[k]
            val ny = j + ay[k]
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue
            val nv = arr[nx][ny]
            if(!check[nx][ny]) {
                if(b) {
                    when(cv) {
                        "R", "G" -> if(nv != "B") dfs(nx, ny, b)
                        else -> if(nv == "B") dfs(nx, ny, b)
                    }
                } else {
                    when(cv) {
                        "R" -> if(nv == "R") dfs(nx, ny, b)
                        "G" -> if(nv == "G") dfs(nx, ny, b)
                        else -> if(nv == "B") dfs(nx, ny, b)
                    }
                }
            }
        }
    }
}
