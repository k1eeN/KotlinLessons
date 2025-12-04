package lesson_25_working_with_data.profile

import lesson_25_working_with_data.extensions.myForEach

fun main() {
    showEmail()
}

fun filterCollection() {
    ProfileRepository.profiles
        .filter { it.age > 25 }
        .filter { it.gender == Gender.MALE }
        .filter { it.firstName.startsWith("A") }
        .filter { it.age < 30 }
        .map { it.copy(age = it.age + 1) }
        .sortedBy { it.lastName }
        .myForEach { println(it) }
}

fun showEmail() {
    print("Enter id:")
    val id = readln().toInt()
    ProfileRepository.profiles.find { it.id == id }?.let { println(it.email) } ?: println("Not Found")
}
