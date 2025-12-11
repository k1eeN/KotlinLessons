package lesson_94_invariance_and_covariance.collections

interface MySet<out T> : MyCollection<T> {

    override val size: Int

    override fun contains(element: @UnsafeVariance T): Boolean
}
