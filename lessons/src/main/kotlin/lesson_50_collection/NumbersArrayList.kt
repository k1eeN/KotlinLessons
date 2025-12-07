package lesson_50_collection

class NumbersArrayList : NumberMutableList {

    private var numbers = arrayOfNulls<Int>(10)

    override var size: Int = 0
        private set

    override fun add(number: Int) {
        numbers[size] = number
        size++
    }

    override fun get(index: Int): Int {
        return numbers[index]!!
    }
}