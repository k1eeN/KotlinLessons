package lesson_4_oop.corporation

abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int = 0,
    open val salary: Int = 15000,
    val position: Position
) {

    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    abstract fun work()

    open fun printInfo() {
        println(this)
    }
}
