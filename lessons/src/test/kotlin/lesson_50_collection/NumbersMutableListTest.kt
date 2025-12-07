package lesson_50_collection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumbersMutableListTest {

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 1 element then size is 1`(list: NumberMutableList) {
        list.add(0)
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 10 element then size is 10`(list: NumberMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertEquals(10, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 100 element then size is 100`(list: NumberMutableList) {
        repeat(100) {
            list.add(it)
        }
        assertEquals(100, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 5 element then result is correct`(list: NumberMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertEquals(5, list.get(5))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 50 element then result is correct`(list: NumberMutableList) {
        repeat(100) {
            list.add(it)
        }
        assertEquals(50, list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element removed then size decreased`(list: NumberMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(99, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed 50th element next value at position`(list: NumberMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(51, list.get(50))
    }


    companion object {

        @JvmStatic
        fun mutableListSource() = listOf(NumbersArrayList())

    }

}