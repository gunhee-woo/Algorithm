import java.io.FileInputStream

class RepresentationOfSet_1717 {

    private var n = 0
    private var m = 0
    private val parent = Array(100001) { 0 }

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            m = it[1]
        }
        repeat(n) {
            parent[it + 1] = it + 1
        }
        repeat(m) {
            val (cmd, a, b) = br.readLine().split(" ").map { it.toInt() }
            if(cmd == 0) {
                unionParent(a, b)
            } else {
                if(findParent(a, b)) println("YES")
                else println("NO")
            }
        }
    }

    private fun getParent(x: Int): Int {
        if(parent[x] == x) return x
        parent[x] = getParent(parent[x])
        return parent[x]
    }

    private fun unionParent(_a: Int, _b: Int) {
        val a = getParent(_a)
        val b = getParent(_b)
        if(a > b) parent[a] = b
        else parent[b] = a
    }

    private fun findParent(_a: Int, _b: Int): Boolean {
        val a = getParent(_a)
        val b = getParent(_b)
        return a == b
    }
}

fun main() {
    RepresentationOfSet_1717().solution()
}