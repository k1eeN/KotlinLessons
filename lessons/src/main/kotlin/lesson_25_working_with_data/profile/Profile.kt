package lesson_25_working_with_data.profile

fun main() {
    val profiles = ProfileRepository.profiles
        .filter { it.age > 25 }
        .filter { it.gender == Gender.MALE }
        .filter { it.firstName.startsWith("A") }
        .filter { it.age < 30 }
        .map { it.copy(age = it.age + 1) }

    for (person in profiles) {
        println(person)
    }
}
