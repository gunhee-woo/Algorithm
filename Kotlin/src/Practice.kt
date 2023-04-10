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
    //    ���� �а���
    System.setIn(FileInputStream(INPUT))
    System.`in`.bufferedReader().run {
//
        // Read
//        val arr = readLine().split(" ").map { it.toInt() }
//        val char = readLine().toCharArray()

        // 2���� �迭 �а� ������ ����
        // Test1, ���ڿ�
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

        // Test2, ����
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
//        val bw = System.out.bufferedWriter() // ª�� BufferedWriter
    }
}


fun arrayPractice() {
    val size = 3
    val arr = arrayOf(1, 2, "ddd")
    val arr2 = Array(size) { 1 }
    val intArr = intArrayOf(1, 2, 3)
    val intArr2 = IntArray(size)
    val floatArr = floatArrayOf(1.1F, 2f)

    // ���ڿ� �迭
    val strArr = arrayOf("a", "b")
    val strArr2 = Array(size) { "A" }

    // ����ְų� Null �迭
    val intArr3 = IntArray(0)
    val boolArr = BooleanArray(0)
    val emptyArr = emptyArray<String>()
    val emptyArr2 = emptyArray<Int>()
    val nullArr = arrayOfNulls<String>(size)

    print(arr[2])
    // ��ü �迭 ���
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

    // �ʱ�ȭ
    check = Array(3) {
        Array(2) {
            false
        }
    } // ��� ���� ������ �ʱ�ȭ

    intArray = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    ) // �ٸ� ������ �ʱ�ȭ

    // ��ü �迭 ���
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

    // list : �б⸸ ����
    // mutableList : �а� ���� ��� ����

    val n = 3
    val m = 4
    list = MutableList(n) {
        MutableList(m) {
            1
        }
    }
    list[1][1] = 2
    list.forEach { println(it.toString()) }

    // 2���� ����Ʈ

    val arrayList = arrayListOf(2, 3)
    arrayList += 4
    println(arrayList)

    // MutableList �� ArrayList �Ѵ� �а� ���Ⱑ ������ ��ǻ� ���� ����� ����
    // MutableList = �߰�, ���� �� ������ ������ ����Ʈ
    // ArrayList = ���ο� Array �� �����Ǿ� �ִ� �߰�, ���� �� ������ ������ ����Ʈ
    // ���� Kotlin ������ mutableList �� arrayListOf�� �� �� ArrayList �� ��ȯ
}

fun stackPractice() {
    // ��Ʋ�������� MutableList �� ����ó�� ����� �� �ִ�
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
    // ��Ʋ������ ArrayList�� MutableList�� ���� ������� ����ϴ� ���� ���� �� ������ ����
}

fun queuePractice() {
    // LinkedList �� �����
    val q1: Queue<Int> = LinkedList()
    val q2 = LinkedList<Int>()
    val q3 = LinkedList(listOf("a", "b"))

    q1.add(1)
    println(q1.peek())
    q1.poll()
}

fun dequePractice() {
    // ���� ��쿡�� ArrayDeque �� ����Ѵ�
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
    } // ����Ʈ���� ��������
    printHeap(pq)
    val pq2 = PriorityQueue<Int> { o1, o2 ->
        o2 - o1 // ��������
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
    } // �������� ��� 2
    printHeap(pq3)

    val pq4 = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        if(o1.first != o2.first) o1.first - o2.first else o1.second - o2.second
    }.apply {
        add(1 to 3)
        add(1 to 2)
        add(2 to 1)
        add(3 to 1)
    } // first �� second ���� �켱������ ���� �������� ����
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
    // Set ������ ���� ���� �÷���, �ߺ��� ������� ����
    // 1. �Һ��� Set (�ڷ��� ȥ�� ����)
    val set = setOf("String", 1, 2, 1.1f, "OK", 1)
    println(set)

    // 2. ������ Set
    val set2 = mutableSetOf("cat", "dog")
    set2.add("hippo")
    set2.remove("cat")
    println(set2)

    // 3. ������ HashSet
    // ���������� �ؽ����̺�(Ű�� �ε���)�� ����Ͽ� �˻��� ���� ���� ������ ó���� �� �ִ� �ڷᱸ��
    // �˻��ӵ��� O(1)
    val hashSet = hashSetOf(1, 2, 3)
    hashSet.add(4)
    hashSet.remove(1)
    println(hashSet)

    // 4. ������ SortedSet
    // TreeSet �� ���ĵ� ���·� ��ȯ
    // ������ ����Ž��Ʈ���� �����Ʈ�� �˰��� ���
    // HashSet ���� �����͸� �߰�/�����ϴµ� �ð��� �� �ɷ� ������ ���������� �˻��� ������ �پ
    val sortedSet = sortedSetOf(2, 3, 1, 5)
    sortedSet.add(7)
    sortedSet.remove(2)
    println(sortedSet)
}


lateinit var map: HashMap<Int, String>

fun mapPractice() {
    // 1. �Һ��� Map
    val map1 = mapOf(1 to "A", 2 to "B", 3 to "C")
    println(map1)
    println(map1[1])
    println(map1.values)
    println(map1.keys)

    // 2. ������ Map
    val map2 = mutableMapOf(1 to "A", 2 to "B", 3 to "C")
    map2[4] = "D"
    map2.remove(1)
    println(map2)

    // 3. ������ HashMap
    val hashMap = hashMapOf(1 to "A", 2 to "B")
    println(hashMap)

    // 4. ������ SortedMap
    val sortedMap = sortedMapOf(2 to "B", 3 to "C", 1 to "A", 1 to "B")
    println(sortedMap)
}

fun sortBasicPractice() {

    val list = listOf(3, 5, 1, 7, 2)
    val mutableList = mutableListOf(2, 1, 8, 7, 9)
    mutableList.add(5)

    // 1. �Һ��� ����
    println(list.sorted()) // ���ĵ� ����Ʈ�� ��ȯ

    // 2. ������ ����
    mutableList.sort()
    println(mutableList)

    // 3. �������� ����
//    println(list.sorted().reversed())
    println(list.sortedDescending())

//    mutableList.apply {
//        sort()
//        reverse()
//    }
    mutableList.sortDescending()
    println(mutableList)

    // 4. sortWith (Comparator �� ������ �� ����)
    println(list.sortedWith { o1, o2 -> o1 - o2 })

    mutableList.sortWith { o1, o2 -> o1 - o2}
    println(mutableList)

    // 5. sortBy (���ο� ���� ��ü Ÿ���� ������ ���� �� ex)Pair)
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

fun scopeFunctionPractice() { // ���������Լ�
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