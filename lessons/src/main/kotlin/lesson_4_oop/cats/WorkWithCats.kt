package lesson_4_oop.cats

fun main() {
    val cat = Cat("Sam")
    println(cat.legsCount)
    println(cat.name)
    cat.playWithMouse()
    val lion = Lion(countInPride = 25)
    println(lion.legsCount)
    println(lion.countInPride)
}
