import java.io.FileInputStream

class PrepareForCamp_16938 {

    private var n = 0
    private var l = 0
    private var r = 0
    private var x = 0
    private lateinit var problem: Array<Int>
    private lateinit var arr: Array<Int>
    private lateinit var check: Array<Boolean>
    private var cnt = 0

    fun solution1() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            l = it[1]
            r = it[2]
            x = it[3]
        }
        problem = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        if(n > 1) {
            for(i in 2..n) {
                arr = Array(i) { 0 }
                check = Array(n) { false }
                dfs(0, 0, i)
            }
        }
        println(cnt)
    }

    private fun dfs(k: Int, ix: Int, size: Int) {
        if(k == size) {
            if(arr.sum() in l..r && (arr.max() - arr.min()) >= x) {
                cnt++
            }
            return
        }
        for(i in ix until n) {
            if(!check[i]) {
                check[i] = true
                arr[k] = problem[i]
                dfs(k + 1, i, size)
                check[i] = false
            }
        }
    }

    fun solution2() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            l = it[1]
            r = it[2]
            x = it[3]
        }
        problem = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        dfs2(0, 0, 0, Int.MIN_VALUE, Int.MAX_VALUE)
        println(cnt)
    }

    private fun dfs2(ix: Int, count: Int, sum: Int, max: Int, min: Int) {
        if(ix == n) {
            if(count >= 2 && sum in l..r && (max - min) >= x) {
                cnt++
            }
            return
        }
        dfs2(ix + 1, count + 1, sum + problem[ix], max.coerceAtLeast(problem[ix]), min.coerceAtMost(problem[ix])) // 문제를 선택한다
        dfs2(ix + 1, count, sum, max, min) // 문제를 선택하지 않는다
    }

    // 비트마스크
    fun solution3() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            l = it[1]
            r = it[2]
            x = it[3]
        }
        problem = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        var result = 0
        for(i in 1 until (1 shl n)) {
            var count = 0
            var sum = 0
            var max = Int.MIN_VALUE
            var min = Int.MAX_VALUE
            for(j in 0 until n) {
                if(i and (1 shl j) > 0) {
                    count++
                    sum += problem[j]
                    max = max.coerceAtLeast(problem[j])
                    min = min.coerceAtMost(problem[j])
                }
            }
            if(count >= 2 && sum in l..r && (max - min) >= x) result++
        }
        println(result)
    }
}

fun main() {
//    PrepareForCamp_16938().solution1()
//    PrepareForCamp_16938().solution2()
    PrepareForCamp_16938().solution3()
}