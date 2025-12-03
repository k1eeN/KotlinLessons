package lesson_4_oop.corporation

import kotlin.random.Random

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) : Worker(
    id,
    name,
    age,
    salary,
    Position.CONSULTANT
), Cleaner {

    override fun copy(
        id: Int,
        name: String,
        age: Int,
        salary: Int,
        position: Position
    ): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    override fun clean() {
        println("Consultant: I'm cleaning workplace...")
    }

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
