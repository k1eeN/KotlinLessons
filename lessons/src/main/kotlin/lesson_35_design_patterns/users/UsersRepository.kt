package lesson_35_design_patterns.users

import kotlinx.serialization.json.Json
import lesson_35_design_patterns.observer.Observable
import lesson_35_design_patterns.observer.Observer
import java.io.File

class UsersRepository private constructor(): Observable<List<User>> {

    private val file = File("users.json")

    private val _observers = mutableListOf<Observer<List<User>>>()
    override val observers
        get() = _observers.toList()

    private val _users: MutableList<User> = loadAllUser()

    private fun loadAllUser(): MutableList<User> = Json.decodeFromString(file.readText().trim())

    override val currentValue: List<User>
        get() = _users.toList()

    override fun registerObserver(observer: Observer<List<User>>) {
        _observers.add(observer)
        observer.onChanged(currentValue)
    }

    override fun unregisterObserver(observer: Observer<List<User>>) {
        _observers.remove(observer)
    }

    fun addOnUserChangedListener(observer: Observer<List<User>>) {
        registerObserver(observer)
    }


    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = currentValue.maxOf { it.id } + 1
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