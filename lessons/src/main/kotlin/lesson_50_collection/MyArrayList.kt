package lesson_50_collection

class MyArrayList<T>(initialCapacity: Int = INITIAL_CAPACITY) : MyMutableList<T>, MyCollection<T> {

    private var elements = arrayOfNulls<Any>(initialCapacity)
    private var modeCount = 0

    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
        modeCount++
        growIfNeeded()
        elements[size] = element
        size++
        return true
    }

    private fun growIfNeeded() {
        if (elements.size == size) {
            val newArray = arrayOfNulls<Any>(elements.size * 2)
            System.arraycopy(elements, 0, newArray, 0, size)
            elements = newArray
        }
    }

    override fun add(index: Int, element: T) {
        modeCount++
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(elements, index, elements, index + 1, size - index)
        elements[index] = element
        size++
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun minus(element: T) {
        remove(element)
    }

    override fun removeAt(index: Int) {
        modeCount++
        checkIndex(index)
        System.arraycopy(elements, index + 1, elements, index, size - index - 1)
        size--
        elements[size] == null
    }

    override fun clear() {
        modeCount++
        elements = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun remove(element: T) {
        modeCount++
        for (i in 0 until size) {
            if (elements[i] == element) {
                removeAt(i)
                return
            }
        }
    }

    override fun contains(element: T): Boolean {
        for (i in 0 until size) {
            if (elements[i] == element) {
                return true
            }
        }
        return false
    }

    private fun checkIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index $index Size $size")
        }
    }

    private fun checkIndexForAdding(index: Int) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Index $index Size $size")
        }
    }

    override fun get(index: Int): T {
        checkIndex(index)
        return elements[index] as T
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {

            private var currentModeCount = modeCount
            private var nextIndex = 0

            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): T {
                if (currentModeCount != modeCount) throw ConcurrentModificationException()
                return elements[nextIndex++] as T
            }
        }
    }

    companion object {

        private const val INITIAL_CAPACITY = 10
    }
}