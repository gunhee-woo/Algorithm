package baekJoon.twoPointer

import INPUT
import printMatrix
import java.io.FileInputStream

class ListOfUniqueNumbers_13144 {

    // s ���� e ���� Ž���ϴٰ� e�� ����Ű�� ���� �ߺ��� �� ��� e ������ ������ ��� �ߺ��� ���� �����ϰ� �� => �ʿ䰡 ����
    // n�� �ִ밪�� 100000 �̹Ƿ� ������ Long Ÿ������ �����ؾ� ��
    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toLong()
        val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        var result = n * (n + 1) / 2
        var s = 0
        var e = 0
        val set = mutableSetOf<Int>()
        set.add(arr[e])
        while(true) {
            if(e == n.toInt()) break
            if(s == e) {
                e++
                continue
            }
            if(set.isEmpty()) set.add(arr[s])
            if(set.contains(arr[e])) {
                val value = n - e
                result -= value
                set.remove(arr[s])
                s++
            } else {
                set.add(arr[e])
                e++
            }
        }
        println(result)
    }
}

fun main() {
    ListOfUniqueNumbers_13144().solution()
}