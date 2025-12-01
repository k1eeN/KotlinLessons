package lesson_4_oop.profile

class Person(
    val name: String = "",
    val age: Int = 0,
    val height: Int = 0,
    val weight: Int = 0
) {

    fun printInfo() {
        println("Name: $name Age: $age Height: $height Weight: $weight")
    }

    fun sayHello() {
        println("Hello! My name is $name")
    }

    fun run() {
        repeat(10) {
            print("Running... ")
        }
    }
}
