package baekJoon.backTracking

import INPUT
import java.io.FileInputStream

var n = 0 // 1���� N ������ �ڿ���
var m = 0 // ���̰� M �� ����
lateinit var arr: Array<Int> // ������ ��� �ڷᱸ�� => ũ�⸦ M�� ����
lateinit var check: Array<Boolean> // �ڿ����� ������ ����ߴ��� üũ => ũ�⸦ N�� ���� -> ����, ���տ����� ���
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

// 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
// �ߺ����� ��� ����� ���� ����
// ���� (������ �ְ� �ߺ� X)
// n��m1 15649

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

// 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
// �� ������ ���������̾�� �Ѵ�
// �ߺ����� ���������̶�� ������ ���� ����� ���� ����
// ���� (������ ���� �ߺ� X)
// n��m2_15650

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

// �ߺ����� (������ �ְ�, �ߺ� O)
// 1���� N���� �ڿ��� �߿��� M���� �� ����
// ���� ���� ���� �� ��� �ȴ�.
// n��m3_15651

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

// �ߺ����� (������ ����, �ߺ� O)
// 1���� N���� �ڿ��� �߿��� M���� �� ����
// ���� ���� ���� �� ��� �ȴ�.
// �� ������ �񳻸������̾�� �Ѵ�

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