package lesson_92_mutable_state_flow

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Definition(

    @SerialName("definition") val definition: String,

    )
