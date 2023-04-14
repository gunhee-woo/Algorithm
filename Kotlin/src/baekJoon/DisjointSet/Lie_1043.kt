import java.io.FileInputStream

class Lie_1043 {

    private val parent = Array(51) { 0 }
    private lateinit var partyArr: Array<MutableList<Int>>

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        for (i in 1..n) {
            parent[i] = i
        }
        val tp = br.readLine().split(" ").map { it.toInt() }
        var root = 0
        if(tp[0] > 0) {
            for (i in 1 until tp.size) {
                unionParent(tp[1], tp[i])
            }
            root = tp[1]
        }
        if(tp[0] == 0) {
            println(m)
        } else {
            partyArr = Array(m) { mutableListOf() }
            repeat(m) {
                val line = br.readLine().split(" ").map { itt -> itt.toInt() }
                for(i in 1 until line.size) {
                    unionParent(line[1], line[i])
                    partyArr[it].add(line[i])
                }
            }
            var cnt = 0
            for(i in partyArr.indices) {
                val party = partyArr[i]
                for(j in party.indices) {
                    if(!findParent(root, party[j])) {
                        cnt++
                        break
                    }
                }
            }
            println(cnt)
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
    Lie_1043().solution()
}