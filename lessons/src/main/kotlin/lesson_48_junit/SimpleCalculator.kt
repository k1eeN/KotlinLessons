package lesson_48_junit

class SimpleCalculator : Calculator {

    override fun sum(a: Int, b: Int): Int {
        return a + b
    }

    override fun subtraction(a: Int, b: Int): Int {
        return a - b
    }

    override fun multiplication(a: Int, b: Int): Int {
        return a * b
    }

    override fun division(a: Int, b: Int): Double {
        return a.toDouble() / b
    }
}