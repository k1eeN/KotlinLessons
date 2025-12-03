package lesson_4_oop.profile

fun main() {
    val person1 = Person("Вася", "Пупкин", 180,72)
    val person2 = Person("Вася", "Пупкин", 180,72)
    val person3 = person1.copy()
    val peoples = setOf(person1, person2, person3)
    for (person in peoples) {
        println(person)
    }
}
