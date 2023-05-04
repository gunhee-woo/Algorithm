package baekJoon.simulation

import INPUT
import java.io.FileInputStream
import java.util.*

class MarbleEscape_13459 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val map = Array(n) { Array(m) { "" } }
        var red = 0 to 0
        var blue = 0 to 0
        repeat(n) {
            val line = br.readLine()
            for(i in line.indices) {
                map[it][i] = line[i].toString()
                when(map[it][i]) {
                    "B" -> blue = it to i
                    "R" -> red = it to i
                }
            }
        }
        var result = false
        val ax = arrayOf(-1, 1, 0, 0)
        val ay = arrayOf(0, 0, -1, 1)
        val q: Queue<Triple<Pair<Int, Int>, Pair<Int, Int>, Int>> = LinkedList()
        q.add(Triple(red, blue, 0))
        while(q.isNotEmpty()) {
            val cr = q.peek().first // red
            val cb = q.peek().second // blue
            val cc = q.peek().third
//            println("cr : $cr, cb : $cb, cc : $cc")
            q.poll()
            if(cc > 10) {
                println(0)
                return
            }
            for(i in 0..3) {
                var pr = cr
                var pb = cb
                var isNrHoleArrive = false
                var isNbHoleArrive = false
                while(true) {
                    val nr = pr.first + ax[i] to pr.second + ay[i]
                    val nb = pb.first + ax[i] to pb.second + ay[i]
                    val nc = cc + 1
                    var isNrMove = false
                    var isNbMove = false
                    if(map[nr.first][nr.second] == "O") {
//                        println("nr == O, nr : $nr, nb : $nb, nc : $nc")
                        if(nc <= 10) {
                            isNrHoleArrive = true
                        }
                    }
                    if(map[nb.first][nb.second] == "O") {
//                        println("nb == O, nr : $nr, nb : $nb, nc : $nc")
                        isNbHoleArrive = true
                    }

                    if(map[nr.first][nr.second] != "#") {
                        if(nr == pb) { // 빨간구슬 바로 옆에 파란구슬이 존재할 경우
                            if(map[nb.first][nb.second] != "#") { // 파란구슬이 한 칸 이동이 가능할 경우 -> 빨간구슬도 이동 가능
                                pr = nr
                                isNrMove = true // 빨간구슬이 한 칸 이동에 성공하였다
                            }
                        } else {
                            pr = nr
                            isNrMove = true // 빨간구슬이 한 칸 이동에 성공하였다
                        }
                    }
                    if(map[nb.first][nb.second] != "#") {
                        if(nb == pr) {
                            if(map[nr.first][nr.second] != "#") {
                                pb = nb
                                isNbMove = true
                            }
                        } else {
                            pb = nb
                            isNbMove = true
                        }
                    }
                    if(!isNrMove && !isNbMove) { // 두 구슬 모두 이동하지 못했다 => 어떤 방향의 끝에 도달했다
                        break
                    }
                }
//                println("isNrHoleArrive : $isNrHoleArrive, isNbHoleArrive : $isNbHoleArrive")
                if(isNrHoleArrive) {
                    if(!isNbHoleArrive) {
                        result = true // 빨간구슬만 구멍에 들어갔다
                        break
                    }
                }
                if(!isNrHoleArrive && !isNbHoleArrive) { // 둘 중 하나라도 구멍에 빠지면 이동 끝
                    if(pr != cr || pb != cb) { // 조금이라도 이동이 있었다면
                        q.add(Triple(pr, pb, cc + 1))
                    }
                }
            }
            if(result) {
                println(1)
                return
            }
        }
        println(0)
    }
}

fun main() {
    MarbleEscape_13459().solution()
}