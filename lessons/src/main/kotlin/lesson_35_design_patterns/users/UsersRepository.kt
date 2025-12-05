package lesson_35_design_patterns.users

import kotlinx.serialization.json.Json
import java.io.File

class UsersRepository private constructor() {

    private val file = File("users.json")

    private val observers = mutableListOf<Display>()

    private val _users: MutableList<User> = loadAllUser()
    val users
        get() = _users.toList()

    private fun loadAllUser(): MutableList<User> = Json.decodeFromString(file.readText().trim())

    fun notifyObservers() {
        for (observer in observers) {
            observer.onChanged(users)
        }
    }

    fun registerObserver(observer: Display) {
        observers.add(observer)
        observer.onChanged(users)
    }


    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = users.maxOf { it.id } + 1
        val user = User(id, age, firstName, lastName)
        _users.add(user)
        notifyObservers()
    }

    fun deleteUser(id: Int) {
        _users.removeIf {it.id == id}
        notifyObservers()
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