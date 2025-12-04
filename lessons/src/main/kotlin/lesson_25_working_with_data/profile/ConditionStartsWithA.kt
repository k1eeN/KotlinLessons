package lesson_25_working_with_data.profile

class ConditionStartsWithA: Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.firstName.startsWith("A")
    }
}