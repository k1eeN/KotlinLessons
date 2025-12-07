package lesson_48_junit

class LoggingCalculator : Calculator {

    override fun sum(a: Int, b: Int): Int {
        val result = a + b
        println("Operation: sum($a, $b). Result: $result")
        return result
    }

    override fun subtraction(a: Int, b: Int): Int {
        val result = a - b
        println("Operation: subtraction($a, $b). Result: $result")
        return result
    }

    override fun multiplication(a: Int, b: Int): Int {
        val result = a * b
        println("Operation: multiplication($a, $b). Result: $result")
        return result
    }

    override fun division(a: Int, b: Int): Double {
        val result = a.toDouble() / b
        println("Operation: division($a, $b). Result: $result")
        return result
    }

}