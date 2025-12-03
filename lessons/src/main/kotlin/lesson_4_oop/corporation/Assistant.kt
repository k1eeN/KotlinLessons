package lesson_4_oop.corporation

data class Assistant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) : Worker(
    id,
    name,
    age,
    salary,
    Position.ASSISTANT
), Cleaner, Supplier {

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
        println("Assistant: I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("Assistant: I'm buying things...")
    }

    override fun work() {
        println("I'm answering the phone now.")
    }

    fun bringCoffee(count: Int = 1, drinkName: String = "Cappuccino"): String {
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("Press the \"$drinkName\" button")
            println("Wait for the $drinkName to be prepared")
            println("Take coffee")
            println("Bring coffee to the director")
            println("Put coffee on the table")
            println("Return to the workplace")
        }
        return drinkName
    }
}
