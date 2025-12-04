package lesson_25_working_with_data.profile

fun main() {
    val profiles = ProfileRepository.profiles
        .filter { it.age > 25 }
        .filter { it.gender == Gender.MALE }
        .filter { it.firstName.startsWith("A") }
        .filter { it.age < 30 }
        .transform { it.copy(age = it.age + 1) }

    for (person in profiles) {
        println(person)
    }
}

fun <T> List<Person>.transform(operation: (Person) -> T): List<T> {
    val result = mutableListOf<T>()
    for (person in this) {
        result.add(operation(person))
    }
    return result
}

fun List<Person>.filter(isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()
    for (person in this) {
        if (isSuitable(person)) {
            result.add(person)
        }
    }
    return result
}
