package lesson_4_oop.corporation

open class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: Position
) {

    open fun work() {
        println("I'm working now.")
    }

    open fun printInfo() {
        println("Id: $id Name: $name Age: $age Position: $position")
    }
}
