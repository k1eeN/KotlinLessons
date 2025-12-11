package lesson_91_screen_state_as_flow

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Definition(

    @SerialName("definition") val definition: String,

    )
