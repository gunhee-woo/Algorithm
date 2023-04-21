package baekJoon.simulation

import INPUT
import printMatrix
import java.io.FileInputStream
import java.util.*
import kotlin.math.min

class Maaaaaaaaaze_16985 {

    private lateinit var arr: Array<Array<Array<Int>>>
    private lateinit var rotates: Array<Int>
    private lateinit var stacks: Array<Int>
    private lateinit var check: Array<Boolean>
    private val ax = arrayOf(-1, 1, 0, 0, 0, 0)
    private val ay = arrayOf(0, 0, -1, 1, 0, 0)
    private val az = arrayOf(0, 0, 0, 0, -1, 1)
    private var result = Int.MAX_VALUE

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        var a = 0
        var b = 0
        arr = Array(5) { Array(5) { Array(5) { 0 } } }
        repeat(25) {
            val tmp = br.readLine().split(" ").map { itt -> itt.toInt() }.toTypedArray()
            if(b == 5) {
                b = 0
                a++
            }
            arr[a][b] = tmp
            b++
        }
//        arr.printMatrix()
        rotates = Array(5) { 0 }
        stacks = Array(5) { 0 }
        check = Array(5) { false }
        rotateDfs(0)
        println(if(result == Int.MAX_VALUE) -1 else result)
    }

    private fun rotateDfs(k: Int) {
        if(k == 5) {
            stackDfs(0)
            return
        }
        for(i in 0 until 4) {
            rotates[k] = i
            rotateDfs(k + 1)
        }
    }

    private fun stackDfs(k: Int) {
        if(k == 5) {
            search()
            return
        }
        for(i in 0 until 5) {
            if(!check[i]) {
                check[i] = true
                stacks[k] = i
                stackDfs(k + 1)
                check[i] = false
            }
        }
    }

    // 0 default, 1. 90, 2. 180, 3. 270
    private fun rotate(k: Int, dir: Int): Array<Array<Int>> {
        var temp = arr[k].copyOf()
        repeat(dir) {
            temp = rotate90(temp)
        }
        return temp
    }

    private fun rotate90(temp: Array<Array<Int>>): Array<Array<Int>> {
        val copy = Array(5) { Array(5) { 0 } }
        for(i in 0..4) {
            for(j in 0..4) {
//                if(i == j) continue
                copy[j][4 - i] = temp[i][j]
            }
        }
        return copy
    }

    private fun search() {
        val temp = Array(5) { Array(5) { Array(5) { 0 } } }
        for(i in rotates.indices) {
            temp[stacks[i]] = rotate(i, rotates[i])
        }
        if(temp[0][0][0] == 1 && temp[4][4][4] == 1) {
            val q: Queue<Quad> = LinkedList()
            val check = Array(5) { Array(5) { Array(5) { false } } }
            check[0][0][0] = true
            q.add(Quad(0, 0, 0, 0))
            while(q.isNotEmpty()) {
                val cx = q.peek().x
                val cy = q.peek().y
                val cz = q.peek().z
                val cc = q.peek().cnt
                q.poll()
                if(cx == 4 && cy == 4 && cz == 4) {
//                    println(cc)
                    result = min(result, cc)
                    continue
                }
                for(i in 0..5) {
                    val nx = cx + ax[i]
                    val ny = cy + ay[i]
                    val nz = cz + az[i]
                    if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5 || temp[nx][ny][nz] == 0) continue
                    if(!check[nx][ny][nz]) {
                        check[nx][ny][nz] = true
                        q.add(Quad(nx, ny, nz, cc + 1))
                    }
                }
            }
        }
    }

    private data class Quad(val x: Int, val y: Int, val z: Int, val cnt: Int)
}

fun main() {
    Maaaaaaaaaze_16985().solution()
}