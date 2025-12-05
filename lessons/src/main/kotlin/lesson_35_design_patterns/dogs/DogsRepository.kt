package lesson_35_design_patterns.dogs

import kotlinx.serialization.json.Json
import lesson_35_design_patterns.observer.Observer
import java.io.File


class DogsRepository private constructor() {

    private val file = File("dogs.json")

    private val observers = mutableListOf<Observer<List<Dog>>>()

    private val _dogs: MutableList<Dog> = loadAllDog()
    val dogs
        get() = _dogs.toList()

    private fun loadAllDog(): MutableList<Dog> = Json.decodeFromString(file.readText().trim())

    fun notifyObservers() {
        for (observer in observers) {
            observer.onChanged(dogs)
        }
    }

    fun addOnDogChangedListener(observer: Observer<List<Dog>>) {
        observers.add(observer)
        observer.onChanged(dogs)
    }


    fun addDog(breed: String, name: String, wight: Double) {
        val id = dogs.maxOf { it.id } + 1
        val user = Dog(id, breed, name, wight)
        _dogs.add(user)
        notifyObservers()
    }

    fun deleteDog(id: Int) {
        _dogs.removeIf {it.id == id}
        notifyObservers()
    }

    fun saveChanges() {
        val content = Json.encodeToString(_dogs)
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