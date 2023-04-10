package baekJoon.graph.dfs_bfs

import INPUT
import printMatrix
import java.io.FileInputStream
import java.util.*
import kotlin.math.max

class Gaaaaaaaaaarden_18809 {

    private var n = 0
    private var m = 0
    private var g = 0
    private var r = 0
    private lateinit var map: Array<Array<Int>>
    private lateinit var check: Array<Boolean>
    private lateinit var arr: Array<Point>
    private lateinit var start: MutableList<Pair<Int, Int>>
    private val ax = arrayOf(-1, 1, 0, 0)
    private val ay = arrayOf(0, 0, -1, 1)
    private var result = Int.MIN_VALUE

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            m = it[1]
            g = it[2]
            r = it[3]
        }
        map = Array(n) { Array(m) { 0 } }
        start = mutableListOf()
        repeat(n) { i ->
            val line = br.readLine().split(" ").map { it.toInt() }
            repeat(m) { j ->
                map[i][j] = line[j]
                if(map[i][j] == 2) {
                    start.add(i to j)
                }
            }
        }
        arr = Array(g + r) { Point(0, 0, 0) }
        check = Array(start.size) { false }
        dfs(0, 0, g, r)
        println(result)
    }

    fun dfs(k: Int, ix: Int, gc: Int, rc: Int) {
        if(k == g + r && gc == 0 && rc == 0) {
//            arr.forEach { println("x: ${it.x}, y: ${it.y}, color: ${it.color}") }
//            println()
            result = max(result, bfs())
            return
        }
        for(i in ix until start.size) {
            if(!check[i]) {
                check[i] = true
                val cur = start[i]
                if(gc > 0) {
                    arr[k] = Point(cur.first, cur.second, 3)
                    dfs(k + 1, i, gc - 1, rc)
                }
                if(rc > 0) {
                    arr[k] = Point(cur.first, cur.second, 4)
                    dfs(k + 1, i, gc, rc - 1)
                }
                check[i] = false
            }
        }
    }

    fun bfs(): Int {
        val rm = Array(n) { Array(m) { -1 } }
        val gm = Array(n) { Array(m) { -1 } }
        var rq: Queue<Pair<Int, Int>> = LinkedList()
        var gq: Queue<Pair<Int, Int>> = LinkedList()
        val rv = Array(n) { Array(m) { false } }
        val gv = Array(n) { Array(m) { false } }
        var count = 0
        arr.forEach {
            if(it.color == 3) {
                gq.add(it.x to it.y)
                gm[it.x][it.y] = 0
                gv[it.x][it.y] = true
            } else {
                rq.add(it.x to it.y)
                rm[it.x][it.y] = 0
                rv[it.x][it.y] = true
            }
        }
        while(gq.isNotEmpty() || rq.isNotEmpty()) {
            val nextGq: Queue<Pair<Int, Int>> = LinkedList()
            val nextRq: Queue<Pair<Int, Int>> = LinkedList()
            while(gq.isNotEmpty()) {
                val cx = gq.peek().first
                val cy = gq.peek().second
                gq.poll()
                if(gm[cx][cy] == -2) {
                    continue
                }
                for(i in 0..3) {
                    val nx = cx + ax[i]
                    val ny = cy + ay[i]
                    val nc = gm[cx][cy] + 1
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 0 || gm[nx][ny] == -2) continue
                    if(!gv[nx][ny]) {
                        gv[nx][ny] = true
                        if(rm[nx][ny] != -1 && rm[nx][ny] < nc) continue
                        else if(rm[nx][ny] != -1 && rm[nx][ny] == nc) {
                            gm[nx][ny] = -2
                            rm[nx][ny] = -2
                            count++
                        } else {
                            gm[nx][ny] = nc
                            nextGq.add(nx to ny)
                        }
                    }
                }
            }
            while(rq.isNotEmpty()) {
                val cx = rq.peek().first
                val cy = rq.peek().second
                rq.poll()
                if(rm[cx][cy] == -2) {
                    continue
                }
                for(i in 0..3) {
                    val nx = cx + ax[i]
                    val ny = cy + ay[i]
                    val nc = rm[cx][cy] + 1
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 0 || rm[cx][cy] == -2) continue
                    if(!rv[nx][ny]) {
                        rv[nx][ny] = true
                        if(gm[nx][ny] != -1 && gm[nx][ny] < nc) {
                            continue
                        } else if(gm[nx][ny] != -1 && gm[nx][ny] == nc) {
                            rm[nx][ny] = -2
                            gm[nx][ny] = -2
                            count++
                        } else {
                            rm[nx][ny] = nc
                            nextRq.add(nx to ny)
                        }
                    }
                }
            }
            gq = nextGq
            rq = nextRq
        }
        return count
    }

    data class Point(val x: Int, val y: Int, val color: Int)

//    fun printMap(mp: Array<Array<Int>>) {
//        repeat(n) { i ->
//            repeat(m) { j ->
//                if(mp[i][j] == -1) print("X")
//                else if(mp[i][j] == -2) print("F")
//                else print(mp[i][j])
//            }
//            println()
//        }
//        println()
//    }
}



fun main() {
    Gaaaaaaaaaarden_18809().solution()
}