import java.io.FileInputStream
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
//    fileReadAndWrite()
//    arrayPractice()
//    multiArrayPractice()
//    listPractice()
//    stackPractice()
//    queuePractice()
//    dequePractice()
//    heapPractice()
//    dataClassPractice()
//    setPractice()
//    mapPractice()
//    sortBasicPractice()
//    scopeFunctionPractice()
}

fun fileReadAndWrite() {
    //    파일 읽고쓰기
    System.setIn(FileInputStream(INPUT))
    System.`in`.bufferedReader().run {
//
        // Read
//        val arr = readLine().split(" ").map { it.toInt() }
//        val char = readLine().toCharArray()

        // 2차원 배열 읽고 데이터 저장
        // Test1, 문자열
//        2 3
//        a b c
//        d e f
//        var n = 0
//        var m = 0
//        readLine().split(" ").also {
//            n = it[0].toInt()
//            m = it[1].toInt()
//        }
//        println("n : $n, m : $m")
//        val arr = Array(n) {
//            readLine().split(" ")
//        }
//        arr.forEach { println(it) }

        // Test2, 정수
//        3 3
//        1 2 3
//        4 5 6
//        7 8 9
        var n = 0
        var m = 0
        readLine().split(" ").also {
            n = it[0].toInt()
            m = it[1].toInt()
        }
        println("n : $n, m : $m")
        val arr = Array(n) {
            readLine().split(" ").onEach { it.toInt() }
            readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        arr.forEach { println(it) }


//        // Write
//        print(readLine().toInt())
//        val out = BufferedWriter(OutputStreamWriter(System.out)).run {
//            appendLine()
//            flush()
//            close()
//        }
//        val bw = System.out.bufferedWriter() // 짧은 BufferedWriter
    }
}


fun arrayPractice() {
    val size = 3
    val arr = arrayOf(1, 2, "ddd")
    val arr2 = Array(size) { 1 }
    val intArr = intArrayOf(1, 2, 3)
    val intArr2 = IntArray(size)
    val floatArr = floatArrayOf(1.1F, 2f)

    // 문자열 배열
    val strArr = arrayOf("a", "b")
    val strArr2 = Array(size) { "A" }

    // 비어있거나 Null 배열
    val intArr3 = IntArray(0)
    val boolArr = BooleanArray(0)
    val emptyArr = emptyArray<String>()
    val emptyArr2 = emptyArray<Int>()
    val nullArr = arrayOfNulls<String>(size)

    print(arr[2])
    // 전체 배열 출력
    print(arr.contentToString())
}

lateinit var check: Array<Array<Boolean>>

//var intArray = Array(0) {
//    IntArray(0)
//}

lateinit var intArray: Array<IntArray>

fun multiArrayPractice() {
    val n = 3
    val m = 4
    val arr = Array(n) { Array(n) { "a" } }
    val arr2 = Array(n) { Array(m) { 1 } }
    val arr3 = Array(n) {
        Array(m) {
            arrayOf(1, 2, 3)
        }
    }

    // 초기화
    check = Array(3) {
        Array(2) {
            false
        }
    } // 모두 같은 값으로 초기화

    intArray = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    ) // 다른 값으로 초기화

    // 전체 배열 출력
    intArray.forEach { println(it.contentToString()) }
    println(intArray.contentDeepToString())
}

lateinit var list: MutableList<MutableList<Int>>
lateinit var arrayList : ArrayList<ArrayList<Int>>

fun listPractice() {
    val list1 = listOf(1, 2, 3)
    val list2 = mutableListOf(1, 2, 3)
    val list3 = arrayListOf(1, 2, 3)
    list2 += 4
    println(list2)
    list2.add(5)
    list2.remove(5)
    list2 -= 4
    println(list2)
    list3.add(4)
    list3.remove(1)
    list3 -= 4

    // list : 읽기만 가능
    // mutableList : 읽고 쓰기 모두 가능

    val n = 3
    val m = 4
    list = MutableList(n) {
        MutableList(m) {
            1
        }
    }
    list[1][1] = 2
    list.forEach { println(it.toString()) }

    // 2차원 리스트

    val arrayList = arrayListOf(2, 3)
    arrayList += 4
    println(arrayList)

    // MutableList 와 ArrayList 둘다 읽고 쓰기가 가능함 사실상 같은 기능을 가짐
    // MutableList = 추가, 삭제 등 수정이 가능한 리스트
    // ArrayList = 내부에 Array 로 구현되어 있는 추가, 삭제 등 수정이 가능한 리스트
    // 현재 Kotlin 에서는 mutableList 나 arrayListOf나 둘 다 ArrayList 를 반환
}

fun stackPractice() {
    // 코틀린에서는 MutableList 를 스택처럼 사용할 수 있다
    val mutableList = mutableListOf(1, 2, 3)
    val stack = Stack<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    stack.push(4)
    mutableList.add(4)

    stack.pop()
    mutableList.removeLast()

    println(stack.peek())
    println(mutableList.last())

    // https://velog.io/@tkppp-dev/Kotlin-%EC%8A%A4%ED%83%9D
    // 코틀린에서 ArrayList나 MutableList를 스택 대용으로 사용하는 것은 성능 상 문제가 없다
}

fun queuePractice() {
    // LinkedList 를 사용함
    val q1: Queue<Int> = LinkedList()
    val q2 = LinkedList<Int>()
    val q3 = LinkedList(listOf("a", "b"))

    q1.add(1)
    println(q1.peek())
    q1.poll()
}

fun dequePractice() {
    // 덱의 경우에는 ArrayDeque 를 사용한다
    val dq = ArrayDeque<Int>()
    val dq2 = ArrayDeque(listOf("a", "b"))

    dq.addFirst(1)
    dq.addLast(2)

    println(dq.peekFirst())
    println(dq.peekLast())

    dq.removeFirst()
    dq.removeLast()
}

fun heapPractice() {
    // PriorityQueue
    val pq = PriorityQueue<Int>().apply {
        add(3)
        add(1)
        add(2)
    } // 디폴트값은 오름차순
    printHeap(pq)
    val pq2 = PriorityQueue<Int> { o1, o2 ->
        o2 - o1 // 내림차순
    }.apply {
        add(3)
        add(1)
        add(2)
    }
    printHeap(pq2)
    val pq3 = PriorityQueue(Collections.reverseOrder<Int>()).apply {
        add(3)
        add(1)
        add(2)
    } // 내림차순 방법 2
    printHeap(pq3)

    val pq4 = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        if(o1.first != o2.first) o1.first - o2.first else o1.second - o2.second
    }.apply {
        add(1 to 3)
        add(1 to 2)
        add(2 to 1)
        add(3 to 1)
    } // first 가 second 보다 우선순위를 가진 오름차순 정렬
    printHeap(pq4)
}

fun <T> printHeap(pq: PriorityQueue<T>) {
    while (!pq.isEmpty()) {
        println(pq.poll())
    }
    println()
}

fun dataClassPractice() {
    val triple = Triple(1, 2, "Start")
    println("1 : ${triple.a}, 2: ${triple.b}, 3: ${triple.c}, plus : ${triple.getPlus()}, toString : $triple")
}

data class Triple(val a: Int, val b: Int, val c: String) {
    fun getPlus(): Int = a + b
    override fun toString(): String {
        return "$a, $b, $c"
    }
}

lateinit var set: HashSet<String>

fun setPractice() {
    // Set 순서가 없는 집합 컬렉션, 중복을 허용하지 않음
    // 1. 불변형 Set (자료형 혼합 가능)
    val set = setOf("String", 1, 2, 1.1f, "OK", 1)
    println(set)

    // 2. 가변형 Set
    val set2 = mutableSetOf("cat", "dog")
    set2.add("hippo")
    set2.remove("cat")
    println(set2)

    // 3. 가변형 HashSet
    // 내부적으로 해시테이블(키와 인덱스)을 사용하여 검색과 변경 등을 빠르게 처리할 수 있는 자료구조
    // 검색속도는 O(1)
    val hashSet = hashSetOf(1, 2, 3)
    hashSet.add(4)
    hashSet.remove(1)
    println(hashSet)

    // 4. 가변형 SortedSet
    // TreeSet 을 정렬된 상태로 반환
    // 개선된 이진탐색트리인 레드블랙트리 알고리즘 사용
    // HashSet 보다 데이터를 추가/삭제하는데 시간이 더 걸려 성능이 떨어지지만 검색과 정렬이 뛰어남
    val sortedSet = sortedSetOf(2, 3, 1, 5)
    sortedSet.add(7)
    sortedSet.remove(2)
    println(sortedSet)
}


lateinit var map: HashMap<Int, String>

fun mapPractice() {
    // 1. 불변형 Map
    val map1 = mapOf(1 to "A", 2 to "B", 3 to "C")
    println(map1)
    println(map1[1])
    println(map1.values)
    println(map1.keys)

    // 2. 가변형 Map
    val map2 = mutableMapOf(1 to "A", 2 to "B", 3 to "C")
    map2[4] = "D"
    map2.remove(1)
    println(map2)

    // 3. 가변형 HashMap
    val hashMap = hashMapOf(1 to "A", 2 to "B")
    println(hashMap)

    // 4. 가변형 SortedMap
    val sortedMap = sortedMapOf(2 to "B", 3 to "C", 1 to "A", 1 to "B")
    println(sortedMap)
}

fun sortBasicPractice() {

    val list = listOf(3, 5, 1, 7, 2)
    val mutableList = mutableListOf(2, 1, 8, 7, 9)
    mutableList.add(5)

    // 1. 불변형 정렬
    println(list.sorted()) // 정렬된 리스트를 반환

    // 2. 가변형 정렬
    mutableList.sort()
    println(mutableList)

    // 3. 내림차순 정렬
//    println(list.sorted().reversed())
    println(list.sortedDescending())

//    mutableList.apply {
//        sort()
//        reverse()
//    }
    mutableList.sortDescending()
    println(mutableList)

    // 4. sortWith (Comparator 를 지정할 수 있음)
    println(list.sortedWith { o1, o2 -> o1 - o2 })

    mutableList.sortWith { o1, o2 -> o1 - o2}
    println(mutableList)

    // 5. sortBy (내부에 여러 객체 타입을 가지고 있을 때 ex)Pair)
    val list2 = listOf("b" to 5, "a" to 7, "d" to 9, "c" to 4)
    println(list2.sortedBy { it.first })
    println(list2.sortedByDescending { it.second })

    val mutableList2 = mutableListOf("b" to 5, "a" to 10,  "d" to 7, "c" to 1)
    mutableList2.apply {
        sortBy { it.first }
        println(this)
        sortByDescending { it.second }
        println(this)
    }
}

fun scopeFunctionPractice() { // 범위지정함수
    val list = mutableListOf(5, 1, 6, 3)
    println(list.apply {
        add(2)
    })
    println(list.also {
        it.add(4)
    })
    println(list.run {
        add(7)
    })
    println(list.let {
        it.add(10)
    })
}