package baekJoon.graph.dfs

import INPUT
import java.io.FileInputStream

// DFS 문제
// 일반적인 O(n^2)의 풀이로는 시간초과가 발생
// 따라서 사이클을 만들었는지 체크하는 공간을 활용하여 시간복잡도를 줄임 => DP 식 풀
class TermProject {

    private lateinit var arr: Array<Int>
    private lateinit var check: Array<Boolean>
    private lateinit var isCycle: Array<Boolean>
    private var cnt = 0

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val T = br.readLine().toInt()
        repeat(T) {
            val n = br.readLine().toInt()
            arr = Array(n + 1) { 0 }
            check = Array(n + 1) { false }
            isCycle = Array(n + 1) { false }
            cnt = 0
            br.readLine().split(" ").map { it.toInt() }.withIndex().forEach {
                arr[it.index + 1] = it.value
            }
            for(i in 1..n) {
                if(!check[i]) {
                    dfs(i)
                }
            }
            println(n - cnt)
        }
    }

    // 방문하지 않은 학생만 DFS 를 실행 => 이 경우 모든 학생에 대해 한 번만 방문하므로 O(n)의 시간복잡도를 가짐
    private fun dfs(ix: Int) {
        check[ix] = true
        val next = arr[ix]
        if(!check[next]) {
            dfs(next)
        } else if(!isCycle[next]) { // 방문을 했지만 아직 사이클이 아님 따라서 next 부터 자기자신까지의 사이클을 카운트함
            var i = next
            while(i != ix) {
                cnt++
                i = arr[i]
            }
            cnt++
        }
        isCycle[ix] = true
    }

    // 시간초과
//    private fun dfs(ix: Int, start: Int, list: MutableList<Int>) {
//        val next = arr[ix]
//        if(next == start) {
//            list.forEach { check[it] = true }이
//            cnt -= list.size
//            return
//        }
//        if(list.contains(next)) {
//            list.forEach { check[it] = true }
//            val index = list.indexOf(next)
//            cnt -= (list.size - index)
//            return
//        }
//        if(!check[next] && !list.contains(next)) {
//            list.add(next)
//            dfs(next, start, list)
//        }
//    }

//    private fun dfs(ix: Int, start: Int, cnt: Int, list: MutableList<Int>) {
//        val next = arr[ix]
//        if(next == start) {
//            list.forEach { check[it] = true }
//            return
//        }
//        if(!check[next] && !list.contains(next)) {
//            list.add(next)
//            dfs(next, start, cnt + 1, list)
//        }
//    }
}

fun main() {
    TermProject().solution()
}