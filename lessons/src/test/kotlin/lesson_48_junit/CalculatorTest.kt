package lesson_48_junit

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `When 5 Add To 10 Then Result 15`() {
        val result = calculator.sum(10, 5)
        val expected = 15
        assertEquals(expected, result)
    }

    @Test
    fun `When 10 Add To 10 Then Result 20`() {
        val result = calculator.sum(10, 10)
        val expected = 20
        assertEquals(expected, result)
    }

    @Test
    fun `When 20 Subtracted To 10 Then Result 10`() {
        val result = calculator.subtraction(20, 10)
        val expected = 10
        assertEquals(expected, result)
    }

    @Test
    fun `When 100 Subtracted To 50 Then Result 50`() {
        val result = calculator.subtraction(100, 50)
        val expected = 50
        assertEquals(expected, result)
    }

    @Test
    fun `When 10 Multiplied By 5 Then Result 50`() {
        val result = calculator.multiplication(10, 5)
        val expected = 50
        assertEquals(expected, result)
    }

    @Test
    fun `When 12 Multiplied By 10 Then Result 120`() {
        val result = calculator.multiplication(12, 10)
        val expected = 120
        assertEquals(expected, result)
    }

    @Test
    fun `When 12 Divided By 2 Then Result 6`() {
        val result = calculator.division(12, 2)
        val expected = 6
        assertEquals(expected, result)
    }

    @Test
    fun `When 1000 Divided By 2 Then Result 500`() {
        val result = calculator.division(1000, 2)
        val expected = 500
        assertEquals(expected, result)
    }

}