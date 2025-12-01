package lesson_4_oop.cats

class Cat(val name: String) : CatsFamily() {

    override fun eat() {
        println("Кушаю вискас")
    }

    fun playWithMouse() {
        println("I'm playing with mouse")
    }
}
