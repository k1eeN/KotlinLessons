package lesson_50_collection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test

class NumbersHashSetTest {

    private val numbers = NumbersHashSet()

    @Test
    fun `When added 100 elements then size 100`() {
        repeat(100) {
            numbers.add(it)
        }
        assertEquals(100, numbers.size)
    }

    @Test
    fun `When added 10 similar elements then size 1`() {
        repeat(10) {
            numbers.add(0)
        }
        assertEquals(1, numbers.size)
    }

    @Test
    fun `When adding is succeed then method return true`() {
        assertTrue { numbers.add(0) }
    }

    @Test
    fun `When adding is failed then method return false`() {
        numbers.add(0)
        assertFalse { numbers.add(0) }
    }

    @Test
    fun `When element present in set then method return true`() {
        repeat(10) {
            numbers.add(it)
        }
        assertTrue { numbers.contains(9) }
    }

    @Test
    fun `When element dose not present in set then method return false`() {
        repeat(10) {
            numbers.add(it)
        }
        assertFalse { numbers.contains(10) }
    }

    @Test
    fun `When element remove in set then size is decreased`() {
        repeat(10) {
            numbers.add(it)
        }
        numbers.remove(0)
        assertEquals(9, numbers.size)
    }

    @Test
    fun `When element removed in set then method return false`() {
        repeat(10) {
            numbers.add(it)
        }
        numbers.remove(0)
        assertFalse { numbers.contains(0) }
    }

}