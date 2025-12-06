package lesson_35_design_patterns.dogs

import kotlinx.serialization.json.Json
import lesson_35_design_patterns.observer.MutableObservable
import lesson_35_design_patterns.observer.Observable
import java.io.File


class DogsRepository private constructor() {

    private val file = File("dogs.json")

    private val dogList: MutableList<Dog> = loadAllDog()


    private val _dogs = MutableObservable(dogList.toList())
    val dogs: Observable<List<Dog>>
        get() = _dogs

    private fun loadAllDog(): MutableList<Dog> = Json.decodeFromString(file.readText().trim())



    fun addDog(breed: String, name: String, wight: Double) {
        val id = dogList.maxOf { it.id } + 1
        val user = Dog(id, breed, name, wight)
        dogList.add(user)

        _dogs.currentValue = dogList.toList()
    }

    fun deleteDog(id: Int) {
        dogList.removeIf {it.id == id}
        _dogs.currentValue = dogList.toList()
    }

    fun saveChanges() {
        val content = Json.encodeToString(dogList)
        file.writeText(content)
    }


    companion object {

        private val lock = Any()
        private var instance: DogsRepository? = null

        fun getInstance(password: String): DogsRepository {
            val correctPassword = File("password_dogs.txt").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("WrongPassword")
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }

                return DogsRepository().also { instance = it }
            }
        }
    }
}