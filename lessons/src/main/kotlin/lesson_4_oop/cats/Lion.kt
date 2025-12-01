package lesson_4_oop.cats

class Lion(
    val countInPride: Int
): CatsFamily() {

    override fun eat() {
        println("Кушаю антилопу")
    }
}