package baekJoon.bruteForce

import INPUT
import printMatrix
import java.io.FileInputStream
import java.util.*
import kotlin.math.abs

class CastldDefense_17135 {

    private var n = 0
    private var m = 0
    private var d = 0
    private lateinit var map: Array<Array<Int>>
    private lateinit var copy: Array<Array<Int>>
    private lateinit var arr: Array<Int>
    private lateinit var check: Array<Boolean>
    private var result = Int.MIN_VALUE

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            m = it[1]
            d = it[2]
        }
        map = Array(n) { Array(m) { 0 } }
        copy = Array(n) { Array(m) { 0 } }
        repeat(n) { i ->
            val line = br.readLine().split(" ").map { itt -> itt.toInt() }
            repeat(m) { j ->
                map[i][j] = line[j]
                copy[i][j] = line[j]
            }
        }
        arr = Array(3) { 0 }
        check = Array(m) { false }
        dfs(0, 0)
        println(result)
    }

    private fun dfs(k: Int, ix: Int) {
        if(k == 3) {
            copyMap()
            result = result.coerceAtLeast(defense())
            return
        }
        for(i in ix until m) {
            if(!check[i]) {
                check[i] = true
                arr[k] = i
                dfs(k + 1, i)
                check[i] = false
            }
        }
    }

    private fun copyMap() {
        repeat(n) { i ->
            repeat(m) { j ->
                map[i][j] = copy[i][j]
            }
        }
    }

    private fun defense(): Int {
        var cnt = 0
        for(k in 0 until n) {
            val curY = n - k
            val remove = mutableSetOf<Pair<Int, Int>>()
            arr.forEach {
                val archer = curY to it
                val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
                    if(dist(archer, a) == dist(archer, b)) a.second - b.second
                    else dist(archer, a) - dist(archer, b)
                }
                for(i in 0 until curY) {
                    for(j in 0 until m) {
                        if(map[i][j] == 1 && dist(archer, i to j) <= d) {
                            pq.add(i to j)
                        }
                    }
                }
                if(pq.isNotEmpty()) remove.add(pq.poll())
            }
            remove.forEach {
                map[it.first][it.second] = 0
                cnt++
            }
        }
        return cnt
    }

    private fun dist(a: Pair<Int, Int>, b: Pair<Int,Int>): Int {
        return abs(a.first - b.first) + abs(a.second - b.second)
    }
}

fun main() {
    CastldDefense_17135().solution()
}