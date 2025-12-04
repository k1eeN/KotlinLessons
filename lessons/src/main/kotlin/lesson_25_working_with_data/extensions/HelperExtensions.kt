package lesson_25_working_with_data.extensions

inline fun <R, T> Iterable<T>.transform (operation: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (item in this) {
        result.add(operation(item))
    }
    return result
}

inline fun <T> Iterable<T>.filter(isSuitable: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (isSuitable(item)) {
            result.add(item)
        }
    }
    return result
}

inline fun <T> Iterable<T>.myForEach(operation: (T) -> Unit) {
    for (item in this) {
        operation(item)
    }
}

inline fun <T, R> T.myLet(block: (T) -> R): R {
    return block(this)
}























