package lesson_50_collection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyMutableListTest {

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 1 element then size is 1`(list: MyMutableList<Int>) {
        list + 1
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element added to first position then it is in first position`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list.add(0, 1000)
        assertEquals(1000, list[0])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element added to last position then it is in last position`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list.add(100, 1000)
        assertEquals(1000, list[100])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 10 element then size is 10`(list: MyMutableList<Int>) {
        repeat(10) {
            list.add(it)
        }
        assertEquals(10, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 100 element then size is 100`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertEquals(100, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 5 element then result is correct`(list: MyMutableList<Int>) {
        repeat(10) {
            list.add(it)
        }
        assertEquals(5, list[5])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 50 element then result is correct`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertEquals(50, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element removed then size decreased`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(99, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed 50th element next value at position`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list - 50
        assertEquals(51, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed value 50 next value at position`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list.remove(50)
        assertEquals(51, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list is cleared then size is 0 elements`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list.clear()
        assertEquals(0, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list contain element then method return true`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertTrue(list.contains(90))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list does not contain element then method return false`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertFalse(list.contains(100))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method get invoked with wrong index then exception is throw`(list: MyMutableList<Int>) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> { list[10] }
    }


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method get invoked with negative index then exception is throw`(list: MyMutableList<Int>) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> { list[-10] }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method add invoked with wrong index then exception is throw`(list: MyMutableList<Int>) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> { list.add(11, 1000) }
    }


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method add invoked with negative index then exception is throw`(list: MyMutableList<Int>) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> { list.add(-1, 100) }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method removeAt invoked with wrong index then exception is throw`(list: MyMutableList<Int>) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> { list.removeAt(10) }
    }


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method removeAt invoked with negative index then exception is throw`(list: MyMutableList<Int>) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> { list.removeAt(-1) }
    }


    companion object {

        @JvmStatic
        fun mutableListSource() = listOf(MyArrayList<Int>(), MyLinkedList<Int>())

    }

}