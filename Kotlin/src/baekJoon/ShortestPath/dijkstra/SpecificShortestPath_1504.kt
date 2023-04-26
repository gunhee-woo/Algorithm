package baekJoon.ShortestPath.dijkstra

import INPUT
import printMatrix
import java.io.FileInputStream
import java.util.PriorityQueue
import kotlin.math.min

class SpecificShortestPath_1504 {

    private var n = 0
    private var e = 0
    private val INF = 987654321
    private lateinit var arr: Array<MutableList<Pair<Int, Int>>>
    private lateinit var d: Array<Array<Int>>

    // 1. INF ���� Int.MAX_VALUE ������ ��� OverFlow �߻� ���ɼ��� ����
    // 2. ���� ���� �� ������ �������� �ʴ� ��찡 ����(0 �� E �� 200,000) => ������ ���� ��쿡 ���� ����ó�� �ʿ�
    // 3. �� �������� ������ �ִ밪�� 800�̸� �ð������� 1�� => ���ͽ�Ʈ�� �ð����⵵ O(V^2), �÷��̵� �ͼ� �ð����⵵ O(V^3)
    // ���� �÷��̵� �ͼ��� Ǯ ��� �ð��ʰ��� ���ɼ��� ����. ��, ��� ������ ���Ͽ� ���ͽ�Ʈ�� ����� ��� ���� �ð��ʰ��� ���ɼ��� ����
    // �Ʒ� �ڵ�� 3 * V^2 �̹Ƿ� �ð��ʰ��� �ɸ��� ����

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            e = it[1]
        }
        arr = Array(n + 1) { mutableListOf() }
        d = Array(4) { Array(n + 1) { INF } }
        repeat(e) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            arr[a].add(b to c)
            arr[b].add(a to c)
        }
        // 1: start, 2: v1 - v2, 3: end
        val (v1, v2) = br.readLine().split(" ").map { it.toInt() }
        if(e == 0) {
            println(-1)
            return
        }
        dijkstra(1, 1)
        dijkstra(2, v1)
        dijkstra(3, v2)
        d.printMatrix()
        val result = min(d[1][v1] + d[2][v2] + d[3][n], d[1][v2] + d[3][v1] + d[2][n])
        println(if(result >= INF) -1 else result)
    }

    private fun dijkstra(ix: Int, start: Int) {
        val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
            o1.second - o2.second
        }
        pq.add(start to 0)
        d[ix][start] = 0
        while(pq.isNotEmpty()) {
            val cur = pq.peek().first
            val cost = pq.peek().second
            pq.poll()
            if(d[ix][cur] < cost) continue
            for(i in arr[cur].indices) {
                val next = arr[cur][i].first
                val nextCost = cost + arr[cur][i].second
                if(d[ix][next] > nextCost) {
                    d[ix][next] = nextCost
                    pq.add(next to nextCost)
                }
            }
        }
    }
}

fun main() {
    SpecificShortestPath_1504().solution()
}