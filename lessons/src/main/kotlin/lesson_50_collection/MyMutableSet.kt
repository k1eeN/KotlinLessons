package lesson_50_collection

interface MyMutableSet<T> {

    val size: Int

    fun add(element: T): Boolean

    fun remove(element: T)

    fun clear()

    fun contains(element: T): Boolean
}