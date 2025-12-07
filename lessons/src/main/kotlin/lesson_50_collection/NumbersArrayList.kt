package lesson_50_collection

class NumbersArrayList : NumberMutableList {

    private var numbers = arrayOfNulls<Int>(10)

    override var size: Int = 0
        private set

    override fun add(number: Int) {
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            for (index in numbers.indices) {
                newArray[index] = numbers[index]
            }
            numbers = newArray
        }
        numbers[size] = number
        size++
    }

    override fun removeAt(index: Int) {
        for (i in index until size - 1) {
            numbers[i] = numbers[i + 1]
        }
        size--
        numbers[size] == null
    }

    override fun get(index: Int): Int {
        return numbers[index]!!
    }
}