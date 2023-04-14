import java.io.FileInputStream
import kotlin.math.min

class Pro_17089 {

    private var n = 0
    private var m = 0
    private lateinit var arr: Array<Int>
    private lateinit var check: Array<Boolean>
    private lateinit var nums: Array<Int>
    private lateinit var friends: Array<MutableSet<Int>>
    private var result = Int.MAX_VALUE

    fun solution() {
        System.setIn(FileInputStream(INPUT))
        val br = System.`in`.bufferedReader()
        br.readLine().split(" ").map { it.toInt() }.also {
            n = it[0]
            m = it[1]
        }
        arr = Array(n) { 0 }
        for(i in 0 until n) arr[i] = i + 1
        check = Array(n) { false }
        nums = Array(3) { 0 }
        friends = Array(n + 1) { mutableSetOf() }
        repeat(m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            friends[a].add(b)
            friends[b].add(a)
        }
//        friends.printMatrix()
        dfs(0, 0)
        if(result == Int.MAX_VALUE) println(-1) else println(result)
    }

    private fun dfs(ix: Int, k: Int) {
        if(k == 3) {
//            nums.printMatrix()
            var temp = 0
            if(friends[nums[0]].size > 2) temp += friends[nums[0]].size - 2
            if(friends[nums[1]].size > 2) temp += friends[nums[1]].size - 2
            if(friends[nums[2]].size > 2) temp += friends[nums[2]].size - 2
//            println("temp : $temp")
            result = min(result, temp)
            return
        }
        for(i in ix until n) {
            if(!check[i] && isFriend(k, i)) {
                check[i] = true
                nums[k] = arr[i]
                dfs(i, k + 1)
                check[i] = false
            }
        }
    }

    private fun isFriend(k: Int, ix: Int): Boolean {
        var b = false
        if(k == 0) b = true
        else if(k == 1) {
            if(friends[nums[0]].contains(arr[ix])) {
                b = true
            }
        } else if(k == 2) {
            if(friends[nums[0]].contains(arr[ix]) && friends[nums[1]].contains(arr[ix])) {
                b = true
            }
        }
        return b
    }
}

fun main() {
    Pro_17089().solution()
}