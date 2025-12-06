package lesson_35_design_patterns.users

import kotlinx.serialization.json.Json
import lesson_35_design_patterns.observer.MutableObservable
import java.io.File

class UsersRepository private constructor() {

    private val file = File("users.json")

    private val _users: MutableList<User> = loadAllUser()

    val users = MutableObservable(_users.toList())
    val oldestUser = MutableObservable(_users.maxBy { it.age })

    private fun loadAllUser(): MutableList<User> = Json.decodeFromString(file.readText().trim())


    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = _users.maxOf { it.id } + 1
        val user = User(id, age, firstName, lastName)
        _users.add(user)
        users.currentValue = _users.toList()

        if (age > oldestUser.currentValue.age) {
            oldestUser.currentValue = user
        }
    }

    fun deleteUser(id: Int) {
        _users.removeIf {it.id == id}
        users.currentValue = _users.toList()

        val newOldest = _users.maxBy { it.age }
        if (newOldest != oldestUser.currentValue) {
            oldestUser.currentValue = newOldest
        }
    }

    fun saveChanges() {
        val content = Json.encodeToString(_users)
        file.writeText(content)
    }


    companion object {

        private val lock = Any()
        private var instance: UsersRepository? = null

        fun getInstance(password: String): UsersRepository {
            val correctPassword = File("password_users.txt").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("WrongPassword")
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }

                return UsersRepository().also { instance = it }
            }
        }
    }
}