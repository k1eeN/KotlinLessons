package lesson_25_working_with_data.profile

class ConditionOlderThen25: Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.age > 25
    }
}