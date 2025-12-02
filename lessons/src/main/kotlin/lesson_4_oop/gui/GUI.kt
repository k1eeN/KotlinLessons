package lesson_4_oop.gui

fun main() {
    val rectangle = Rectangle(8, 13)
    println(rectangle.area)
    rectangle.height = 10
    println(rectangle.area)
}