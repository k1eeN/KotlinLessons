package lesson_94_invariance_and_covariance.collections

interface MyMap<out K, out V> {

    val size: Int

    operator fun get(key: @UnsafeVariance K): V?

    fun containsKey(key: @UnsafeVariance K): Boolean

    fun containsValue(value: @UnsafeVariance V): Boolean

    val keys: MySet<K>

    val values: MyCollection<V>
}
