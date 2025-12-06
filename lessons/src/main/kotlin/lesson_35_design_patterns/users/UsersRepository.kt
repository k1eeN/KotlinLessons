package lesson_35_design_patterns.users

import kotlinx.serialization.json.Json
import lesson_35_design_patterns.observer.MutableObservable
import lesson_35_design_patterns.observer.Observable
import java.io.File

class UsersRepository private constructor() {

    private val file = File("users.json")

    private val userList: MutableList<User> = loadAllUser()


    private val _users = MutableObservable(userList.toList())
    val users: Observable<List<User>>
        get() = _users

    private val _oldestUser = MutableObservable(userList.maxBy { it.age })
    val oldestUser: Observable<User>
        get() =_oldestUser

    private fun loadAllUser(): MutableList<User> = Json.decodeFromString(file.readText().trim())


    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = userList.maxOf { it.id } + 1
        val user = User(id, age, firstName, lastName)
        userList.add(user)
        _users.currentValue = userList.toList()

        if (age > _oldestUser.currentValue.age) {
            _oldestUser.currentValue = user
        }
    }

    fun deleteUser(id: Int) {
        userList.removeIf {it.id == id}
        _users.currentValue = userList.toList()

        val newOldest = userList.maxBy { it.age }
        if (newOldest != _oldestUser.currentValue) {
            _oldestUser.currentValue = newOldest
        }
    }

    fun saveChanges() {
        val content = Json.encodeToString(userList)
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