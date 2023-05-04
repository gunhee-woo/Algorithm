package baekJoon.simulation

import INPUT
import printMatrix
import java.io.FileInputStream

class Cubing {

    // 0 윗면(U), 1 아랫면(D), 2 앞면(F), 3 뒷면(B), 4 왼쪽면(L), 5 오른쪽면(R)
    // 0 흰색(w), 1 노란색(y), 2 빨간색(r), 3 오렌지색(o), 4 초록색(g), 5 파란색(b)
    private var n = 0
    private lateinit var map: Array<Array<Array<Int>>>

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val t = br.readLine().toInt()
        repeat(t) {
            n = br.readLine().toInt()
            map = Array(6) { Array(3) { Array(3) { 0 } } }
            init()
//            map.printMatrix()
            br.readLine().split(" ").forEach {
                rotate(it[0].toString(), it[1].toString())
            }
//            for(k in 0..5) {
//                for(i in 0..2) {
//                    for(j in 0..2) {
//                        print(numToString(map[k][i][j]))
////                        print(map[k][i][j])
//                    }
//                    println()
//                }
//                println()
//            }
            for(i in 0..2) {
                for(j in 0..2) {
                    print(numToString(map[0][i][j]))
//                        print(map[0][i][j])
                }
                println()
            }

        }
    }

    private fun init() {
        map[0] = Array(3) { Array(3) { 0 } }
        map[1] = Array(3) { Array(3) { 1 } }
        map[2] = Array(3) { Array(3) { 2 } }
        map[3] = Array(3) { Array(3) { 3 } }
        map[4] = Array(3) { Array(3) { 4 } }
        map[5] = Array(3) { Array(3) { 5 } }
    }

    private fun rotate(case: String, d: String) {
        when(case) {
            "L", "R" -> sideRotate(case, d)
            "U", "D" -> upDownRotate(case, d)
            "F", "B" -> frontBackRotate(case, d)
        }
    }

    private fun sideRotate(case: String, d: String) {
        val ix = if(case == "L") Triple(0, 3, 6) else Triple(2, 5, 8)
        val arr = arrayOf(0, 2, 1, 3)
        if(case == "L" && d == "+" || case == "R" && d == "-") {
            var pre1 = map[arr[0]][ix.first / 3][ix.first % 3]
            var pre2 = map[arr[0]][ix.second / 3][ix.second % 3]
            var pre3 = map[arr[0]][ix.third / 3][ix.third % 3]
            for(i in 1..3) {
                val temp1 = map[arr[i]][ix.first / 3][ix.first % 3]
                val temp2 = map[arr[i]][ix.second / 3][ix.second % 3]
                val temp3 = map[arr[i]][ix.third / 3][ix.third % 3]
                map[arr[i]][ix.first / 3][ix.first % 3] = pre1
                map[arr[i]][ix.second / 3][ix.second % 3] = pre2
                map[arr[i]][ix.third / 3][ix.third % 3] = pre3
                pre1 = temp1
                pre2 = temp2
                pre3 = temp3
            }
            map[arr[0]][ix.first / 3][ix.first % 3] = pre1
            map[arr[0]][ix.second / 3][ix.second % 3] = pre2
            map[arr[0]][ix.third / 3][ix.third % 3] = pre3
        } else {
            var pre1 = map[arr[0]][ix.first / 3][ix.first % 3]
            var pre2 = map[arr[0]][ix.second / 3][ix.second % 3]
            var pre3 = map[arr[0]][ix.third / 3][ix.third % 3]
            for(i in 3 downTo 1) {
                val temp1 = map[arr[i]][ix.first / 3][ix.first % 3]
                val temp2 = map[arr[i]][ix.second / 3][ix.second % 3]
                val temp3 = map[arr[i]][ix.third / 3][ix.third % 3]
                map[arr[i]][ix.first / 3][ix.first % 3] = pre1
                map[arr[i]][ix.second / 3][ix.second % 3] = pre2
                map[arr[i]][ix.third / 3][ix.third % 3] = pre3
                pre1 = temp1
                pre2 = temp2
                pre3 = temp3
            }
            map[arr[0]][ix.first / 3][ix.first % 3] = pre1
            map[arr[0]][ix.second / 3][ix.second % 3] = pre2
            map[arr[0]][ix.third / 3][ix.third % 3] = pre3
        }
    }

    private fun upDownRotate(case: String, d: String) {
        val ix = if(case == "U") Triple(0, 1, 2) else Triple(6, 7, 8)
        val arr = arrayOf(2, 5, 3, 4)
        if(case == "U" && d == "+" || case == "D" && d == "-") {
            var pre1 = map[arr[0]][ix.first / 3][ix.first % 3]
            var pre2 = map[arr[0]][ix.second / 3][ix.second % 3]
            var pre3 = map[arr[0]][ix.third / 3][ix.third % 3]
            for(i in 1..3) {
                val temp1 = map[arr[i]][ix.first / 3][ix.first % 3]
                val temp2 = map[arr[i]][ix.second / 3][ix.second % 3]
                val temp3 = map[arr[i]][ix.third / 3][ix.third % 3]
                map[arr[i]][ix.first / 3][ix.first % 3] = pre1
                map[arr[i]][ix.second / 3][ix.second % 3] = pre2
                map[arr[i]][ix.third / 3][ix.third % 3] = pre3
                pre1 = temp1
                pre2 = temp2
                pre3 = temp3
            }
            map[arr[0]][ix.first / 3][ix.first % 3] = pre1
            map[arr[0]][ix.second / 3][ix.second % 3] = pre2
            map[arr[0]][ix.third / 3][ix.third % 3] = pre3
        } else {
            var pre1 = map[arr[0]][ix.first / 3][ix.first % 3]
            var pre2 = map[arr[0]][ix.second / 3][ix.second % 3]
            var pre3 = map[arr[0]][ix.third / 3][ix.third % 3]
            for(i in 3 downTo 1) {
                val temp1 = map[arr[i]][ix.first / 3][ix.first % 3]
                val temp2 = map[arr[i]][ix.second / 3][ix.second % 3]
                val temp3 = map[arr[i]][ix.third / 3][ix.third % 3]
                map[arr[i]][ix.first / 3][ix.first % 3] = pre1
                map[arr[i]][ix.second / 3][ix.second % 3] = pre2
                map[arr[i]][ix.third / 3][ix.third % 3] = pre3
                pre1 = temp1
                pre2 = temp2
                pre3 = temp3
            }
            map[arr[0]][ix.first / 3][ix.first % 3] = pre1
            map[arr[0]][ix.second / 3][ix.second % 3] = pre2
            map[arr[0]][ix.third / 3][ix.third % 3] = pre3
        }
    }

    private fun frontBackRotate(case: String, d: String) {
        val ix = if(case == "F") Triple(6, 7, 8) else Triple(0, 1, 2)
        val arr = arrayOf(0, 5, 1, 4)
        if(case == "F" && d =="+" || case == "B" && d == "-") {
            var pre1 = map[arr[0]][ix.first / 3][ix.first % 3]
            var pre2 = map[arr[0]][ix.second / 3][ix.second % 3]
            var pre3 = map[arr[0]][ix.third / 3][ix.third % 3]
            for(i in 1..3) {
                val temp1 = map[arr[i]][ix.first / 3][ix.first % 3]
                val temp2 = map[arr[i]][ix.second / 3][ix.second % 3]
                val temp3 = map[arr[i]][ix.third / 3][ix.third % 3]
                map[arr[i]][ix.first / 3][ix.first % 3] = pre1
                map[arr[i]][ix.second / 3][ix.second % 3] = pre2
                map[arr[i]][ix.third / 3][ix.third % 3] = pre3
                pre1 = temp1
                pre2 = temp2
                pre3 = temp3
            }
            map[arr[0]][ix.first / 3][ix.first % 3] = pre1
            map[arr[0]][ix.second / 3][ix.second % 3] = pre2
            map[arr[0]][ix.third / 3][ix.third % 3] = pre3
        } else {
            var pre1 = map[arr[0]][ix.first / 3][ix.first % 3]
            var pre2 = map[arr[0]][ix.second / 3][ix.second % 3]
            var pre3 = map[arr[0]][ix.third / 3][ix.third % 3]
            for(i in 3 downTo 1) {
                val temp1 = map[arr[i]][ix.first / 3][ix.first % 3]
                val temp2 = map[arr[i]][ix.second / 3][ix.second % 3]
                val temp3 = map[arr[i]][ix.third / 3][ix.third % 3]
                map[arr[i]][ix.first / 3][ix.first % 3] = pre1
                map[arr[i]][ix.second / 3][ix.second % 3] = pre2
                map[arr[i]][ix.third / 3][ix.third % 3] = pre3
                pre1 = temp1
                pre2 = temp2
                pre3 = temp3
            }
            map[arr[0]][ix.first / 3][ix.first % 3] = pre1
            map[arr[0]][ix.second / 3][ix.second % 3] = pre2
            map[arr[0]][ix.third / 3][ix.third % 3] = pre3
        }
    }

    private fun numToString(num: Int): String {
        return when(num) {
            0 -> "w"
            1 -> "y"
            2 -> "r"
            3 -> "o"
            4 -> "g"
            else -> "b"
        }
    }
}

fun main() {
    Cubing().solution()
}

// 같은면을 같은방향으로 연속적으로 4의 배수로 돌리면 같은자리에 위치하게 됨
// 또 같은 면을 두번 연속으로 서로 다른방향으로 돌리면 같은자리에 위치하게 됨
// 시간을 줄일 수 있을것으로 생각됨