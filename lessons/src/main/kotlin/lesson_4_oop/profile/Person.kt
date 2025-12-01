package lesson_4_oop.profile

class Person(
    private val name: String,
    private val age: Int,
    private val height: Int,
    private val weight: Int
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
