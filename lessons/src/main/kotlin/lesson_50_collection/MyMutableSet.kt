package lesson_50_collection

interface MyMutableSet<T> : MyMutableCollection<T> {

    override val size: Int

    override fun add(element: T): Boolean

    override fun remove(element: T)

    override fun clear()

    override fun contains(element: T): Boolean
}