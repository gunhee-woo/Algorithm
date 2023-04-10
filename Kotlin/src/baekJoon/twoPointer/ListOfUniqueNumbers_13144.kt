package baekJoon.twoPointer

import INPUT
import printMatrix
import java.io.FileInputStream

class ListOfUniqueNumbers_13144 {

    // s 부터 e 까지 탐색하다가 e가 가리키는 값이 중복이 될 경우 e 이후의 값들은 모두 중복된 수를 포함하게 됨 => 필요가 없음
    // n의 최대값이 100000 이므로 변수를 Long 타입으로 설정해야 함
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