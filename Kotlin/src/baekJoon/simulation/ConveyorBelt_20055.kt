import java.io.FileInputStream
import kotlin.collections.ArrayDeque

class ConveyorBelt_20055 {

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val dq = ArrayDeque<Int>()
        val rq = ArrayDeque<Boolean>()
        br.readLine().split(" ").map { it.toInt() }.forEach {
            dq.add(it)
            rq.add(false)
        }
        var count = 1
        while(true) {
            // 1
            dq.addFirst(dq.removeLast())
            rq.addFirst(rq.removeLast())
            rq[n - 1] = false

            // 2
            var ix = n - 1
            while(ix > 0) {
                if(rq[ix - 1] && dq[ix] >= 1 && !rq[ix]) {
                    rq[ix] = true
                    dq[ix]--
                    rq[ix - 1] = false
                }
                ix--
            }
            rq[n - 1] = false

            // 3
            if(!rq[0] && dq[0] > 0) {
                rq[0] = true
                dq[0]--
            }

            if(dq.count { it == 0 } >= k) {
                println(count)
                return
            }
            count++
        }
    }
}

fun main() {
    ConveyorBelt_20055().solution()
}