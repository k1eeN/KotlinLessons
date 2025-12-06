package lesson_47_builder.builder

fun main() {
    val drink = Drink.Builder()
        .type("Tea")
        .temperature("Cold")
        .diningOption("In Cafe")
        .build()
    println(drink)
}