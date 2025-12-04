package lesson_25_working_with_data.profile

fun main() {
    val profiles = ProfileRepository.profiles

    var filtered = filter(profiles) { it.age > 25 }
    filtered = filter(filtered) { it.gender == Gender.MALE }
    filtered = filter(filtered) { it.firstName.startsWith("A") }
    filtered = filter(filtered) { it.age < 30 }

    val transformed = transform(filtered) { it.copy(age = it.age + 1) }

    for (person in transformed) {
        println(person)
    }
}

fun <T> transform(profiles: List<Person>, operation: (Person) -> T): List<T> {
    val result = mutableListOf<T>()
    for (person in profiles) {
        result.add(operation(person))
    }
    return result
}

fun filter(profiles: List<Person>, isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()
    for (person in profiles) {
        if (isSuitable(person)) {
            result.add(person)
        }
    }
    return result
}
