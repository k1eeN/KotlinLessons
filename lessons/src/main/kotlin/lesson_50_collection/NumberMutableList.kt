package lesson_50_collection

interface NumberMutableList {

    val size: Int

    fun add(number: Int)

    fun add(index: Int, number: Int)

    operator fun plus(number: Int)

    operator fun minus(number: Int)

    operator fun get(index: Int): Int

    fun removeAt(index: Int)

    fun remove(number: Int)

    fun clear()

    fun contains(number: Int): Boolean
}