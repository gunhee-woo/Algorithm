package baekJoon.graph.dfs

import INPUT
import java.io.FileInputStream

// DFS ����
// �Ϲ����� O(n^2)�� Ǯ�̷δ� �ð��ʰ��� �߻�
// ���� ����Ŭ�� ��������� üũ�ϴ� ������ Ȱ���Ͽ� �ð����⵵�� ���� => DP �� Ǯ
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

    // �湮���� ���� �л��� DFS �� ���� => �� ��� ��� �л��� ���� �� ���� �湮�ϹǷ� O(n)�� �ð����⵵�� ����
    private fun dfs(ix: Int) {
        check[ix] = true
        val next = arr[ix]
        if(!check[next]) {
            dfs(next)
        } else if(!isCycle[next]) { // �湮�� ������ ���� ����Ŭ�� �ƴ� ���� next ���� �ڱ��ڽű����� ����Ŭ�� ī��Ʈ��
            var i = next
            while(i != ix) {
                cnt++
                i = arr[i]
            }
            cnt++
        }
        isCycle[ix] = true
    }

    // �ð��ʰ�
//    private fun dfs(ix: Int, start: Int, list: MutableList<Int>) {
//        val next = arr[ix]
//        if(next == start) {
//            list.forEach { check[it] = true }��
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