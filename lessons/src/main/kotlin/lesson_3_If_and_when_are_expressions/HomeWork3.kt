package lesson_3_if_and_when_are_expressions

fun main() {
    val month = readln()
    val seasons = when (month) {
        "Декабрь", "Январь", "Февраль" -> "Зима"
        "Март", "Апрель", "Май" -> "Весна"
        "Июнь", "Июль", "Август" -> "Лето"
        "Сентябрь", "Октябрь", "Ноябрь" -> "Осень"
        else -> ""
    }

    if (seasons == "") {
        println("Такого месяца нету")
    } else {
        println("Время года $seasons")
    }
}