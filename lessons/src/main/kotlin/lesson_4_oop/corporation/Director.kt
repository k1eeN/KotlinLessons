package lesson_4_oop.corporation

class Director(
    id: Int,
    name: String,
    age: Int
) : Worker(id, name, age, Position.DIRECTOR), Supplier {

    override fun buyThings() {
        println("Director: I'm buying things...")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("\nConsultant ${consultant.name} served $count clients")
    }

    fun takeCoffee(assistant: Assistant) {
        val drinkName: String = assistant.bringCoffee()
        println("Thank you, ${assistant.name}! The $drinkName is very tasty :)")
    }

    override fun work() {
        println("I'm drinking coffee")
    }
}
