package lesson_4_oop.cats

class Cat(val name: String) : CatsFamily() {

    fun playWithMouse() {
        println("I'm playing with mouse")
    }
}
