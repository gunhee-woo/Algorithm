package baekJoon.graph.bfs

import java.io.FileInputStream
import java.util.*
import kotlin.collections.HashSet

class Key_9328 {

    private lateinit var arr: Array<Array<Char>>
    private lateinit var check: Array<Array<Boolean>>
    private lateinit var keys: HashSet<Char>
    private lateinit var doors: Array<MutableList<Pair<Int, Int>>>
    private var ax = arrayOf(-1, 1, 0, 0)
    private var ay = arrayOf(0, 0, -1, 1)
    private var h = 0
    private var w = 0
    private var result = 0

    fun solution() {
        //System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val T = br.readLine().toInt()
        repeat(T) {
            br.readLine().split(" ").map { itt -> itt.toInt() }.also {
                h = it[0]
                w = it[1]
            }
            arr = Array(h) { Array(w) { ' ' } }
            check = Array(h) { Array(w) { false } }
            keys = hashSetOf()
            doors = Array(26) { mutableListOf() }
            val startArr = mutableListOf<Pair<Int, Int>>()
            result = 0
            for(i in 0 until h) {
                br.readLine().forEachIndexed { j, s ->
                    arr[i][j] = s
                    if(i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                        if(s != '*') {
                            if(s in 'A'..'Z') {
                                doors[s - 'A'].add(i to j)
                            }
                            startArr.add(i to j)
                        }
                    }
                }
            }
//            startArr.forEach { println("${it.first}, ${it.second}") }
//            arr.printMatrix()
            br.readLine().takeIf { it != "0" }?.forEach {
                keys.add(it)
            }
            startArr.forEach {
                if(!check[it.first][it.second]) {
                    val start = arr[it.first][it.second]
                    if(start in 'A'..'Z') {
                        if(keys.contains(Character.toLowerCase(start))) {
                            bfs(it)
                        }
                    } else if(start in 'a'..'z') {
                        keys.add(start)
                        bfs(it)
                    } else if(start == '$') {
                        result++
                        bfs(it)
                    } else {
                        bfs(it)
                    }
                }
            }
            println(result)
        }
    }

    private fun bfs(start: Pair<Int, Int>) {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(start)
        check[start.first][start.second] = true
        while (q.isNotEmpty()) {
            val cx = q.peek().first
            val cy = q.peek().second
            q.poll()
            for(i in 0..3) {
                val nx = cx + ax[i]
                val ny = cy + ay[i]
                if(nx < 0 || nx >= h || ny < 0 || ny >= w || arr[nx][ny] == '*') continue
                if(!check[nx][ny]) {
                    val next = arr[nx][ny]
//                    println("next : $next nx: $nx, ny: $ny")
                    if(next in 'a'..'z') {
                        q.add(nx to ny)
                        check[nx][ny] = true
                        doors[next - 'a'].forEach {
                            if(!check[it.first][it.second]) {
                                q.add(it.first to it.second)
                                check[it.first][it.second] = true
                            }
                        }
                        keys.add(next)
                    } else if(next in 'A'..'Z') {
                        if(keys.contains(Character.toLowerCase(next))) {
                            q.add(nx to ny)
                            check[nx][ny] = true
                        } else {
                            doors[next - 'A'].add(nx to ny)
                        }
                    } else if(next == '$') {
                        result++
                        q.add(nx to ny)
                        check[nx][ny] = true
                    } else {
                        q.add(nx to ny)
                        check[nx][ny] = true
                    }
                }
            }
        }
    }
}

fun main() {
    Key_9328().solution()
}