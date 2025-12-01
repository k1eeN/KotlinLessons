package lesson_4_oop.gui

class Rectangle(
    val width: Int = 0,
    val height: Int = 0
) {

    constructor(size: Int) : this(size, size)

    fun draw() {
        repeat(height) {
            repeat(width) {
                print("*  ")
            }
            println()
        }
    }
}
