package lesson_35_design_patterns.dogs

import kotlinx.serialization.json.Json
import lesson_35_design_patterns.users.User
import java.io.File

class DogsRepository private constructor() {

    private val file = File("dogs.json")

    private val _dogs: MutableList<Dog> = loadAllDogs()
    val dogs
        get() = _dogs.toList()

    private fun loadAllDogs(): MutableList<Dog> = Json.decodeFromString(file.readText().trim())



    companion object {

        private val lock = Any()
        private var instance: DogsRepository? = null

        fun getInstance(password: String): DogsRepository {
            val correctPassword = File("password_users.txt").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("WrongPassword")
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }

                return DogsRepository().also { instance = it }
            }
        }
    }
}