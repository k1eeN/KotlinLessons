package lesson_3_if_and_when_are_expressions

fun main() {
    val index = readln().toInt()
    val month = when (index) {
        1 -> "Январь"
        2 -> "Февраль"
        3 -> "Март"
        4 -> "Апрель"
        5 -> "Май"
        6 -> "Июнь"
        7 -> "Июль"
        8 -> "Август"
        9 -> "Сентябрь"
        10 -> "Октябрь"
        11 -> "Ноябрь"
        12 -> "Декабрь"
        else -> ""
    }

    if (index in 1..12) {
        println("Месяц: $month")
    } else {
        println("Такого месяца нету")
    }
}