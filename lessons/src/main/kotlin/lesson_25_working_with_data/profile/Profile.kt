package lesson_25_working_with_data.profile

import lesson_25_working_with_data.extensions.myForEach

fun main() {
    ProfileRepository.profiles
        .filter { it.age > 25 }
        .filter { it.gender == Gender.MALE }
        .filter { it.firstName.startsWith("A") }
        .filter { it.age < 30 }
        .map { it.copy(age = it.age + 1) }
        .sortedBy { it.lastName }
        .myForEach { println(it) }
}
