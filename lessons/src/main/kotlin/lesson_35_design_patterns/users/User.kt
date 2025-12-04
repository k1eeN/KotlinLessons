package lesson_35_design_patterns.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id") val id: Int,
    @SerialName("age") val age: Int,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String
)