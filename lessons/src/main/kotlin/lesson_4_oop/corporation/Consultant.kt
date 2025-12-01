package lesson_4_oop.corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name: String,
    age: Int = 0
): Worker(id, name, age, Position.CONSULTANT) {

    override fun work() {
        serveCustomers()
    }

    fun serveCustomers(): Int {
        val count = Random.nextInt(0, 100)
        repeat(count) {
            print("The customer is served... ")
        }
        println("\n")
        return count
    }

    fun sayHello() {
        print("Hi! My name is $name.")
        if (age > 0) {
            print(" I'm $age years old.\n")
        }
    }
}
