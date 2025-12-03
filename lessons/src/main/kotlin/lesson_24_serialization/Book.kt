package lesson_24_serialization

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val name: String,
    val author: String,
    val year: Int
)
