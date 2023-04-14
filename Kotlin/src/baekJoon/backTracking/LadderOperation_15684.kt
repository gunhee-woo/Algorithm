import java.io.FileInputStream

class LadderOperation_15684 {

    private lateinit var visit: Array<Array<Boolean>>
    private var n = 0
    private var m = 0
    private var h = 0
    private var count = Int.MAX_VALUE

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            m = it[1]
            h = it[2]
        }
        visit = Array(h) { Array(n - 1) { false } }
        if(m != 0) {
            repeat(m) {
                val (a, b) = br.readLine().split(" ").map { it.toInt() }
                visit[a - 1][b - 1] = true
            }
            for(k in 0..3) {
                dfs(0,0, k)
                if(count != Int.MAX_VALUE) {
                    println(count)
                    return
                }
            }
            println(-1)
        } else {
            println(0)
        }
    }

    private fun dfs(x: Int, cnt: Int, k: Int) {
        if(k == cnt) {
            if(move()) {
                count = cnt
            }
            return
        }
        for(i in x until h) {
            for(j in 0 until n - 1) {
                if(n != 2) {
                    if(j == 0) {
                        if(!visit[i][j] && !visit[i][j + 1]) {
                            visit[i][j] = true
                            dfs(i, cnt + 1, k)
                            visit[i][j] = false
                        }
                    } else if(j == n - 2) {
                        if(!visit[i][j] && !visit[i][j - 1]) {
                            visit[i][j] = true
                            dfs(i, cnt + 1, k)
                            visit[i][j] = false
                        }
                    } else {
                        if(!visit[i][j] && !visit[i][j - 1] && !visit[i][j + 1]) {
                            visit[i][j] = true
                            dfs(i, cnt + 1, k)
                            visit[i][j] = false
                        }
                    }
                } else {
                    if(!visit[i][j]) {
                        visit[i][j] = true
                        dfs(i, cnt + 1, k)
                        visit[i][j] = false
                    }
                }
            }
        }
    }

    private fun move(): Boolean {
        var result = true
        for(start in 0 until n) {
            var i = 0
            var j = start
            while(i < h) {
                if(j == 0) {
                    if(visit[i][j]) j++
                } else if(j == n - 1) {
                    if(visit[i][j - 1]) j--
                } else {
                    if(visit[i][j - 1]) j--
                    else if(visit[i][j]) j++
                }
                i++
            }
            if(start != j) {
                result = false
                break
            }
        }
        return result
    }
}

fun main() {
    LadderOperation_15684().solution()
}