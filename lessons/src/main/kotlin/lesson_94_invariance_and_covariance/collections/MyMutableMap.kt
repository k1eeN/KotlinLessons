package lesson_94_invariance_and_covariance.collections

interface MyMutableMap<K, V> {

    val size: Int

    fun put(key: K, value: V): V?

    operator fun get(key: K): V?

    fun containsKey(key: K): Boolean

    fun containsValue(value: V): Boolean

    fun clear()

    fun remove(key: K): V?

    val keys: MySet<K>

    val values: MyCollection<V>
}