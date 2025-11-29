package lesson_2_ranges

fun main() {
    val numbers  = 0..1000 step 2
    print("Введите число: ")
    val number = readln().toInt()
    val result = number in numbers
    println(result)
}