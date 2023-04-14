import java.io.FileInputStream

class MakePassword_1759 {

    private var L = 0
    private var C = 0
    private lateinit var arr: Array<Char>
    private lateinit var letters: CharArray
    private lateinit var check: Array<Boolean>
    private val vowel = setOf('a', 'e', 'i', 'o', 'u')

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            L = it[0]
            C = it[1]
        }
        letters = br.readLine().filter { it != ' ' }.toCharArray()
        letters.sort()
        arr = Array(L) { ' ' }
        check = Array(C) { false }
        dfs(0, 0,0,0)
    }

    private fun dfs(k: Int, ix: Int, a: Int, b: Int) {
        if(k == L) {
            if(a >= 1 && b >= 2) {
                for(i in 0 until L) {
                    print(arr[i])
                }
                println()
            }
            return
        }
        for(i in ix until C) {
            if(!check[i]) {
                check[i] = true
                arr[k] = letters[i]
                if(vowel.contains(arr[k])) dfs(k + 1, i, a + 1, b)
                else dfs(k + 1, i, a, b + 1)
                check[i] = false
            }
        }
    }
}

fun main() {
    MakePassword_1759().solution()
}