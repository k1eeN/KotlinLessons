package lesson_4_oop.corporation

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) : Worker(
    id,
    name,
    age,
    salary,
    Position.DIRECTOR
), Supplier {

    override fun copy(
        id: Int,
        name: String,
        age: Int,
        salary: Int,
        position: Position
    ): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

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
