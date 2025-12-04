package lesson_35_design_patterns.users

import kotlinx.serialization.json.Json
import java.io.File

class UsersRepository private constructor() {

    private val file = File("users.json")

    private val _users: MutableList<User> = loadAllUser()
    val users
        get() = _users.toList()

    private fun loadAllUser(): MutableList<User> = Json.decodeFromString(file.readText().trim())



    companion object {

        private var instance: UsersRepository? = null

        fun getInstance(password: String): UsersRepository {
            val correctPassword = File("password_users.txt").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("WrongPassword")
            if (instance == null) {
                instance = UsersRepository()
            }
            return instance!!
        }
    }
}