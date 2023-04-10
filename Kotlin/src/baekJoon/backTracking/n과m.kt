package baekJoon.backTracking

import INPUT
import java.io.FileInputStream

var n = 0 // 1부터 N 까지의 자연수
var m = 0 // 길이가 M 인 수열
lateinit var arr: Array<Int> // 수열을 담는 자료구조 => 크기를 M에 맞춤
lateinit var check: Array<Boolean> // 자연수를 이전에 사용했는지 체크 => 크기를 N에 맞춤 -> 순열, 조합에서만 사용
val sb = StringBuilder()

fun main() {
    System.setIn(FileInputStream(INPUT))
    val br = System.`in`.bufferedReader()
    br.readLine().split(" ").also {
        n = it[0].toInt()
        m = it[1].toInt()
    }
    arr = Array(m) { 0 }
    check = Array(n) { false }
//    dfs1(0)
//    dfs2(0, 0)
//    dfs3(0)
    dfs4(0, 0)
    print(sb.toString())
}

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 중복없이 모든 경우의 수를 구함
// 순열 (순서가 있고 중복 X)
// n과m1 15649

fun dfs1(k: Int) {
    if(k == m) {
        arr.forEach { sb.append("$it ") }
        sb.append("\n")
        return
    }
    for(i in 0 until n) {
        if(!check[i]) {
            check[i] = true
            arr[k] = i + 1
            dfs1(k + 1)
            check[i] = false
        }
    }
}

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다
// 중복없이 오름차순이라는 조건을 가진 경우의 수를 구함
// 조합 (순서가 없고 중복 X)
// n과m2_15650

fun dfs2(k: Int, ix: Int) {
    if(k == m) {
        arr.forEach { sb.append("$it ") }
        sb.append("\n")
        return
    }
    for(i in ix until n) {
        if(!check[i]) {
            check[i] = true
            arr[k] = i + 1
            dfs2(k + 1, i)
            check[i] = false
        }
    }
}

// 중복순열 (순서가 있고, 중복 O)
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
// n과m3_15651

fun dfs3(k: Int) {
    if(k == m) {
        arr.forEach { sb.append("$it ") }
        sb.append("\n")
        return
    }
    for(i in 0 until n) {
        arr[k] = i + 1
        dfs3(k + 1)
    }
}

// 중복조합 (순서가 없고, 중복 O)
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
// 고른 수열은 비내림차순이어야 한다

fun dfs4(k: Int, ix: Int) {
    if(k == m) {
        arr.forEach { sb.append("$it ") }
        sb.append("\n")
        return
    }
    for(i in ix until n) {
        arr[k] = i + 1
        dfs4(k + 1, i)
    }
}