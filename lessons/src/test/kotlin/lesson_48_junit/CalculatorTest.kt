package lesson_48_junit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {


    @ParameterizedTest
    @MethodSource("calculatorSource")
    fun `When 5 Add To 10 Then Result 15`(calculator: Calculator) {
        val result = calculator.sum(10, 5)
        val expected = 15
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSource")
    fun `When 10 Add To 10 Then Result 20`(calculator: Calculator) {
        val result = calculator.sum(10, 10)
        val expected = 20
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSource")
    fun `When 20 Subtracted To 10 Then Result 10`(calculator: Calculator) {
        val result = calculator.subtraction(20, 10)
        val expected = 10
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSource")
    fun `When 100 Subtracted To 50 Then Result 50`(calculator: Calculator) {
        val result = calculator.subtraction(100, 50)
        val expected = 50
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSource")
    fun `When 10 Multiplied By 5 Then Result 50`(calculator: Calculator) {
        val result = calculator.multiplication(10, 5)
        val expected = 50
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSource")
    fun `When 12 Multiplied By 10 Then Result 120`(calculator: Calculator) {
        val result = calculator.multiplication(12, 10)
        val expected = 120
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSource")
    fun `When 12 Divided By 2 Then Result 6`(calculator: Calculator) {
        val result = calculator.division(12, 2)
        val expected = 6.0
        assertEquals(expected, result, 0.001)
    }

    @ParameterizedTest
    @MethodSource("calculatorSource")
    fun `When 1000 Divided By 2 Then Result 500`(calculator: Calculator) {
        val result = calculator.division(1000, 2)
        val expected = 500.0
        assertEquals(expected, result, 0.001)
    }

    companion object {

        @JvmStatic
        fun calculatorSource() = listOf(SimpleCalculator(), LoggingCalculator())

    }


}