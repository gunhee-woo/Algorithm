package baekJoon.simulation

import INPUT
import java.io.FileInputStream
import java.util.*
import kotlin.collections.HashMap

class RobotCleaner_4991 {

    private var w = 0
    private var h = 0
    private lateinit var map: Array<Array<String>>
    private lateinit var visit: Array<Array<Array<Boolean>>>
    private lateinit var keyMap: HashMap<Pair<Int, Int>, Int>
    private var start = 0 to 0
    private var ix = 0
    private val ax = arrayOf(-1, 1, 0, 0)
    private val ay = arrayOf(0, 0, -1, 1)
    private var result = 0

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        while (true) {
            br.readLine().split(" ").map { it.toInt() }.also {
                w = it[0]
                h = it[1]
            }
            if(w == 0 && h == 0) return
            map = Array(h) { Array(w) { "" } }
            visit = Array(h) { Array(w) { Array(1 shl 10) { false } } }
            keyMap = HashMap()
            result = 0
            ix = 0
            repeat(h) { i ->
                val line = br.readLine()
                line.forEachIndexed { j, c ->
                    map[i][j] = c.toString()
                    if(map[i][j] == "*") {
                        keyMap[i to j] = ix++
                    } else if(map[i][j] == "o") {
                        start = i to j
                    }
                }
            }
            keyMap.entries.forEach {
                println("${it.key}, ${it.value}")
            }
            bfs()
            println(result)
        }
    }

    private fun bfs() {
        val q: Queue<Pair<Pair<Int, Int>, Pair<Int, Int>>> = LinkedList()
        q.add(start to (0 to 0))
        map[start.first][start.second] = "."
        visit[start.first][start.second][0] = true
        while(q.isNotEmpty()) {
            val cx = q.peek().first.first
            val cy = q.peek().first.second
            val cc = q.peek().second.first
            val ck = q.peek().second.second
            q.poll()
            if(ck == (1 shl keyMap.size) - 1) {
                result = cc
                break
            }
            for(i in 0..3) {
                val nx = cx + ax[i]
                val ny = cy + ay[i]
                if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == "x") continue
                if(map[nx][ny] == "*") {
                    val nk = ck or (1 shl keyMap[nx to ny]!!)
                    if(!visit[nx][ny][nk]) {
                        visit[nx][ny][nk] = true
                        q.add((nx to ny) to (cc + 1 to nk))
                    }
                }
//                if(!visit[nx][ny][ck]) {
//                    if(map[nx][ny] == "*") {
//                        val nk = ck or (1 shl keyMap[nx to ny]!!)
//                        visit[nx][ny][nk] = true
//                        q.add((nx to ny) to (cc + 1 to nk))
//                    } else {
//                        visit[nx][ny][ck] = true
//                        q.add((nx to ny) to (cc + 1 to ck))
//                    }
//                }
            }
        }
    }
}

fun main() {
    RobotCleaner_4991().solution()
}