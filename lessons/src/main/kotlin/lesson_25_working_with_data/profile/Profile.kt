package lesson_25_working_with_data.profile

fun main() {
    val profiles = ProfileRepository.profiles
    for (person in profiles) {
        println(person)
    }
}
