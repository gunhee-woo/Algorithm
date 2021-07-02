package BaekJoon.BackTracking

import Util.Constants.INPUT
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.system.exitProcess

lateinit var map: Array<IntArray>
lateinit var hLine: Array<BooleanArray>
lateinit var vLine: Array<BooleanArray>
lateinit var square: Array<BooleanArray>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    System.setIn(FileInputStream(INPUT))
    map = Array(9) { IntArray(9) }
    hLine = Array(9) { BooleanArray(10) }
    vLine = Array(9) { BooleanArray(10) }
    square = Array(9) { BooleanArray(10) }
    for (i in 0..8) {
        val st = StringTokenizer(readLine())
        for (j in 0..8) {
            map[i][j] = st.nextToken().toInt()
            if (map[i][j] != 0) {
                hLine[i][map[i][j]] = true
                vLine[j][map[i][j]] = true
                square[squareIndex(i, j)][map[i][j]] = true
            }
        }
    }
    print()
}

private fun squareIndex(x: Int, y: Int): Int {
    return 3 * (x / 3) + y / 3
}

private fun dfs(k: Int) {
    if (k == 81) {
        print()
        exitProcess(0)
        return
    }
    val x = k / 9
    val y = k % 9
    if (map[x][y] == 0) {
        for (i in 1..9) {
            if (!hLine[x][i] && !vLine[y][i] && !square[squareIndex(x, y)][i]) {
                hLine[x][i] = true
                vLine[y][i] = true
                square[squareIndex(x, y)][i] = true
                map[x][y] = i
                dfs(k + 1)
                map[x][y] = 0
                hLine[x][i] = false
                vLine[y][i] = false
                square[squareIndex(x, y)][i] = false
            }
        }
    } else {
        dfs(k + 1)
    }
}

private fun print() {
    for (i in 0..8) {
        for (j in 0..8) {
            print(map[i][j].toString() + " ")
        }
        println()
    }
    println()
}