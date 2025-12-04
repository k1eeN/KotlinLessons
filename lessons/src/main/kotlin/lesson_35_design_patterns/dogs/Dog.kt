package lesson_35_design_patterns.dogs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    @SerialName("id") val id: Int,
    @SerialName("breed_name") val breedName: String,
    @SerialName("dog_name") val dogName: String,
    @SerialName("weight") val weight: Double
)