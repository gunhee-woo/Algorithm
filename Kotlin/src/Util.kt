const val INPUT = "C:\\Users\\bibiq\\IdeaProjects\\Algorithm2\\Kotlin\\src\\text.txt" // Áý

fun <T> Array<out T>.printMatrix() {
    this.forEach {
        when(it) {
            is Array<*> -> it.printMatrix()
            else -> print("$it ")
        }
    }
    println()
}

fun <T> List<T>.printList() {
    this.forEach {
        when(it) {
            is List<*> -> it.printList()
            else -> print("$it ")
        }
    }
    println()
}