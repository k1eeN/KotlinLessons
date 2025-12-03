package lesson_25_working_with_data.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProductCategory {

    @SerialName("Electronics")ELECTRONIC,
    @SerialName("Clothing")CLOTHING,
    @SerialName("Home Goods")HOME_GOODS,
    @SerialName("Beauty")BEAUTY,
    @SerialName("Sports")SPORTS
}