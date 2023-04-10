import java.io.FileInputStream
import java.util.*

class PipeMove1_17070 {

    private lateinit var arr: Array<Array<Int>>
    private var n = 0
    private var result = 0

    // 0 가로, 1 세로, 2 대각선
    private val dx = Array(3) { arrayOf(0) }.also {
        it[0] = arrayOf(0, 1)
        it[1] = arrayOf(1, 1)
        it[2] = arrayOf(0, 1, 1)
    }
    private val dy = Array(3) { arrayOf(0) }.also {
        it[0] = arrayOf(1, 1)
        it[1] = arrayOf(0, 1)
        it[2] = arrayOf(1, 0, 1)
    }
    private val dd = Array(3) { arrayOf(0) }.also {
        it[0] = arrayOf(0, 2)
        it[1] = arrayOf(1, 2)
        it[2] = arrayOf(0, 1, 2)
    }

    // BFS 풀이
    // BFS 를 사용할 경우 이미 방문한 정점에 대해 중복을 제거하는 연산을 추가적으로 수행해야 함 => 시간초과 발생
    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        arr = Array(n) { Array(n) { 0 } }
        repeat(n) {
            arr[it] = br.readLine().split(" ").map { itt -> itt.toInt() }.toTypedArray()
        }
        var result = 0
        val q: Queue<kotlin.Triple<Int, Int, Int>> = LinkedList()
        q.add(Triple(0, 1, 0))
        while(q.isNotEmpty()) {
            val cx = q.peek().first
            val cy = q.peek().second
            val cd = q.peek().third
//            println("cx : $cx, cy : $cy, cd : $cd")
            q.poll()
            if(cx == n - 1 && cy == n - 1) {
                result++
                continue
            }
            for(i in 0 until dx[cd].size) {
                val nx = cx + dx[cd][i]
                val ny = cy + dy[cd][i]
                val nd = dd[cd][i]
//                println("nx : $nx, ny : $ny, nd : $nd")
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 1) continue
                if(nd == 2) {
                    if(arr[cx + 1][cy] == 1 || arr[cx][cy + 1] == 1) continue
                }
                q.add(Triple(nx, ny, nd))
            }
        }
        println(result)
    }

    // DFS 풀이
    fun solution2() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        arr = Array(n) { Array(n) { 0 } }
        repeat(n) {
            arr[it] = br.readLine().split(" ").map { itt -> itt.toInt() }.toTypedArray()
        }
        dfs(0, 1, 0)
        println(result)
    }

    // 0 가로, 1 세로, 2 대각선
    private fun dfs(x: Int, y: Int, d: Int) {
        if(x == n - 1 && y == n - 1) {
            println("x : $x, y : $y, d : $d")
            result++
            return
        }
        for(i in dx[d].indices) {
            val nx = x + dx[d][i]
            val ny = y + dy[d][i]
            val nd = dd[d][i]
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 1) continue
            if(nd == 2) {
                if(arr[x + 1][y] == 1 || arr[x][y + 1] == 1) continue
            }
            dfs(nx, ny, nd)
        }
    }

    private lateinit var dp: Array<Array<Array<Int>>>

    // Top-Down DP 풀이
    fun solution3() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        arr = Array(n) { Array(n) { 0 } }
        dp = Array(n) { Array(n) { Array(3) { 0 } } }
        repeat(n) {
            arr[it] = br.readLine().split(" ").map { itt -> itt.toInt() }.toTypedArray()
        }
        println(dfs2(0, 1, 0))
    }

    private fun dfs2(x: Int, y: Int, d: Int): Int {
        if(dp[x][y][d] > 0) return dp[x][y][d]
        if(x == n - 1 && y == n - 1) return 1
        for(i in dx[d].indices) {
            val nx = x + dx[d][i]
            val ny = y + dy[d][i]
            val nd = dd[d][i]
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 1) continue
            if(nd == 2) {
                if(arr[x + 1][y] == 1 || arr[x][y + 1] == 1) continue
            }
            dp[x][y][d] += dfs2(nx, ny, nd)
        }
        return dp[x][y][d]
    }

    // Bottom-Up DP 풀이
    fun solution4() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        arr = Array(n) { Array(n) { 0 } }
        dp = Array(n) { Array(n) { Array(3) { 0 } } }
        repeat(n) {
            arr[it] = br.readLine().split(" ").map { itt -> itt.toInt() }.toTypedArray()
        }
        dp[0][1][0] = 1
        for(j in 2 until n) {
            for(i in 0 until n) {
                if(arr[i][j] == 1) continue
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
                if(i > 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
                    if(arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
                    }
                }
            }
        }
        println(dp[n - 1][n - 1].sum())
    }
}

fun main() {
//    PipeMove1_17070().solution()
//    PipeMove1_17070().solution2()
//    PipeMove1_17070().solution3()
    PipeMove1_17070().solution4()
}