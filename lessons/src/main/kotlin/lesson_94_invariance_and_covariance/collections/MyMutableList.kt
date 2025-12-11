package lesson_94_invariance_and_covariance.collections

interface MyMutableList<T> : MyList<T>, MyMutableCollection<T> {

    override val size: Int

    override fun add(element: T): Boolean

    operator fun plus(element: T)

    operator fun minus(element: T)

    fun add(index: Int, element: T)

    override operator fun get(index: Int): T

    fun removeAt(index: Int)

    override fun remove(element: T)

    override fun clear()

    override fun contains(element: T): Boolean
}
