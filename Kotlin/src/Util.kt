const val INPUT = "C:\\Users\\bibiq\\IdeaProjects\\Algorithm2\\Kotlin\\src\\text.txt" // Áý

fun <T> Array<out T>.printMatrix(tag: String = "") {
    if(tag.isNotEmpty()) println(tag)
    this.forEach {
        when(it) {
            is Array<*> -> it.printMatrix()
            is List<*> -> it.printList()
            else -> print("$it ")
        }
    }
    println()
}

fun <T> List<T>.printList(tag: String = "") {
    if(tag.isNotEmpty()) println(tag)
    this.forEach {
        when(it) {
            is List<*> -> it.printList()
            is Array<*> -> it.printMatrix()
            else -> print("$it ")
        }
    }
    println()
}