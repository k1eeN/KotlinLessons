package lesson_50_collection

interface MyMutableList<T> : MyMutableCollection<T> {

    override val size: Int

    override fun add(element: T): Boolean

    fun add(index: Int, element: T)

    operator fun plus(element: T)

    operator fun minus(element: T)

    operator fun get(index: Int): T

    fun removeAt(index: Int)

    override fun remove(element: T)

    override fun clear()

    override fun contains(element: T): Boolean
}