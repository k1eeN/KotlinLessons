package lesson_25_working_with_data.profile

import kotlinx.serialization.json.Json
import java.io.File

object ProfileRepository {

    private val file = File("profiles.json")

    private val _profiles = loadProfiles()
    val profiles
        get() = _profiles.toList()

    private fun loadProfiles(): List<Person> {
        val content = file.readText().trim()
        return Json.decodeFromString(content)
    }

}

