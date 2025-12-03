package lesson_25_working_with_data.profile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Gender {

    @SerialName("Male")
    MALE,

    @SerialName("Female")
    FEMALE

}