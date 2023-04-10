import java.io.FileInputStream
import java.util.*
import kotlin.math.min


class HideAndSeek3 {

    private lateinit var arr: Array<Int>
    private val MAX = 100001

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        arr = Array(MAX) { -1 }
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(n to 0)
        arr[n] = 0
        while(q.isNotEmpty()) {
            val cx = q.peek().first
            val cc = q.peek().second
            println("cx : $cx, cc : $cc")
            q.poll()
            if(cx == k) {
                println(min(arr[cx], cc))
                return
            }
            if(cx + 1 < MAX) {
                if(arr[cx + 1] != -1) {
                    if(arr[cx + 1] > cc + 1) {
                        arr[cx + 1] = cc + 1
                        q.add(cx + 1 to cc + 1)
                    }
                } else {
                    arr[cx + 1] = cc + 1
                    q.add(cx + 1 to cc + 1)
                }
            }
            if(cx - 1 >= 0) {
                if(arr[cx - 1] != -1) {
                    if(arr[cx - 1] > cc + 1) {
                        arr[cx - 1] = cc + 1
                        q.add(cx - 1 to cc + 1)
                    }
                } else {
                    arr[cx - 1] = cc + 1
                    q.add(cx - 1 to cc + 1)
                }
            }
            if(cx * 2 < MAX) {
                if(arr[cx * 2] != -1) {
                    if(arr[cx * 2] > cc) {
                        arr[cx * 2] = cc
                        q.add(cx * 2 to cc)
                    }
                } else {
                    arr[cx * 2] = cc
                    q.add(cx * 2 to cc)
                }
            }
        }
    }

    private lateinit var check: Array<Boolean>

    fun solution2() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        check = Array(MAX) { false }
        val q = PriorityQueue<Pair<Int, Int>> { a, b ->
            a.second - b.second
        }
        q.add(n to 0)
        while(q.isNotEmpty()) {
            val cx = q.peek().first
            val cc = q.peek().second
            println("cx : $cx, cc : $cc")
            q.poll()
            check[cx] = true
            if(cx == k) {
                println(cc)
                return
            }
            if(cx * 2 < MAX && !check[cx * 2]) {
                q.add(cx * 2 to cc)
            }
            if(cx + 1 < MAX && !check[cx + 1]) {
                q.add(cx + 1 to cc + 1)
            }
            if(cx - 1 >= 0 && !check[cx - 1]) {
                q.add(cx - 1 to cc + 1)
            }
        }
    }
}

fun main() {
    HideAndSeek3().solution2()
}