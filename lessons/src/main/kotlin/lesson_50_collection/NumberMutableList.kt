package lesson_50_collection

interface NumberMutableList {

    val size: Int

    fun add(number: Int)

    fun get(index: Int): Int
}