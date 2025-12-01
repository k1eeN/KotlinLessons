package lesson_4_oop.corporation

class Assistant(
    name: String,
    age: Int = 0
) : Worker(name = name, age = age) {

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
