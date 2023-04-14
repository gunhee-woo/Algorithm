import java.io.FileInputStream

class GoTravel_1976 {

    private val parent = Array(201) { 0 }

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        val m = br.readLine().toInt()
        for(i in 0 until n) {
            parent[i] = i
        }
        repeat(n) { i ->
            val line = br.readLine().split(" ").map { it.toInt() }
            for(j in i until n) {
                if(line[j] == 1) {
                    unionParent(i, j)
                }
            }
        }
        var value = -1
        br.readLine().split(" ").map { it.toInt() }.forEach {
            if(value == -1) value = getParent(it - 1)
            else {
                if(value != getParent(it - 1)) {
                    print("NO")
                    return
                }
            }
        }
        print("YES")
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
}

fun main() {
    GoTravel_1976().solution()
}