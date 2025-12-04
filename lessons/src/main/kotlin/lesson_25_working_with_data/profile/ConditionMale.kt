package lesson_25_working_with_data.profile

class ConditionMale: Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.gender == Gender.MALE
    }
}