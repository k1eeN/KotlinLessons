package lesson_94_invariance_and_covariance.collections

interface MyMutableCollection<T> : MyCollection<T>, MutableIterable<T> {

    override val size: Int

    fun add(element: T): Boolean

    fun remove(element: T)

    fun clear()

    override fun contains(element: T): Boolean
}
