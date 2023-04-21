package baekJoon.dp

import INPUT
import printMatrix
import java.io.FileInputStream
import kotlin.math.min

class TSP_2098 {

    private var n = 0
    private var END = 0
    private val INF = 987654321
    private var cost = Array(16) { Array(16) { 0 } }
    private var d = Array(16) { Array(1 shl 16) { 0 } }

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        END = (1 shl n) - 1
        repeat(n) { i ->
            val line = br.readLine().split(" ").map { it.toInt() }
            for(j in line.indices) {
                cost[i][j] = line[j]
            }
        }
        println(dfs(0, 1))
    }

    private fun dfs(node: Int, path: Int): Int {
        if(path == END) { // ��� ���� �湮�ߴµ�
            if(cost[node][0] != 0) { // ���� ���� ���ƿ��� ��ΰ� �����ϸ�
                return cost[node][0]
            }
            return INF // ���� ���� ���ƿ��� ��ΰ� �������� ���� ��
        }
        if(d[node][path] != 0) return d[node][path] // ������ ����� ���� �����ϸ� �״�� ��� (�޸������̼�)
        d[node][path] = INF
        for(i in 0 until n) {
            if(cost[node][i] == 0) continue // ���� ���� ���� ��ΰ� ����
            if(path and (1 shl i) != 0) continue // �̹� �湮�� ����� ���
            d[node][path] = min(d[node][path], cost[node][i] + dfs(i, path or (1 shl i)))
        }
        return d[node][path]
    }
}

fun main() {
    TSP_2098().solution()
}