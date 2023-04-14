import java.io.FileInputStream
import java.util.*

class PuyoPuyo_11559 {

    private lateinit var map: Array<Array<String>>
    private lateinit var visit: Array<Array<Boolean>>
    private val ax = arrayOf(-1, 1, 0, 0)
    private val ay = arrayOf(0, 0, -1, 1)
    private lateinit var total: Queue<Pair<Int, Int>>

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        map = Array(12) { Array(6) { "" } }
        repeat(12) {
            map[it] = br.readLine().map { itt -> itt.toString() }.toTypedArray()
        }
        visit = Array(12) { Array(6) { false } }
        var count = 0
//        map.printMatrix()
        while(true) {
            total = LinkedList()
            repeat(6) {
                for(i in (0 until 12).reversed()) {
                    if(map[i][it] != "." && !visit[i][it]) {
                        bfs(i, it)
                    }
                }
            }
            if(total.isNotEmpty()) {
                count++
                while(total.isNotEmpty()) {
                    val cx = total.peek().first
                    val cy = total.peek().second
                    map[cx][cy] = "."
                    visit[cx][cy] = false
                    total.poll()
                }
                move()
//                map.printMatrix()

            }
            else {
                println(count)
                break
            }
        }
    }

    private fun bfs(x: Int, y: Int) {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        val visitList: MutableList<Pair<Int, Int>> = mutableListOf()
        q.add(x to y)
        visitList.add(x to y)
        visit[x][y] = true
        while(q.isNotEmpty()) {
            val cx = q.peek().first
            val cy = q.peek().second
            val cl = map[cx][cy]
            q.poll()
            for(i in 0..3) {
                val nx = cx + ax[i]
                val ny = cy + ay[i]
                if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue
                if(!visit[nx][ny]) {
                    if(cl == map[nx][ny]) {
                        visit[nx][ny] = true
                        visitList.add(nx to ny)
                        q.add(nx to ny)
                    }
                }
            }
        }
        if(visitList.size >= 4) {
            total.addAll(visitList)
        } else {
            visitList.forEach {
                visit[it.first][it.second] = false
            }
        }
    }

    private fun move() {
        repeat(6) {
            var cnt = 0
            val q: Queue<Int> = LinkedList()
            for(i in (0 until 12).reversed()) {
                if(map[i][it] != ".") {
                    if(cnt != 0) {
                        q.add(i)
                    }
                } else {
                    if(q.isNotEmpty()) {
                        while(q.isNotEmpty()) {
                            val x = q.poll()
                            map[x + cnt][it] = map[x][it]
                            map[x][it] = "."
                        }
                    }
                    cnt++
                }
            }
            if(q.isNotEmpty()) {
                while(q.isNotEmpty()) {
                    val x = q.poll()
                    map[x + cnt][it] = map[x][it]
                    map[x][it] = "."
                }
            }
        }
    }
}

fun main() {
    PuyoPuyo_11559().solution()
}