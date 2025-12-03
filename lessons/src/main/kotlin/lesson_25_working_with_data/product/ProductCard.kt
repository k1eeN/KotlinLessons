package lesson_25_working_with_data.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ProductCard(
    @SerialName("id") val id: Int,
    @SerialName("product_availability") val productAvailability: Boolean,
    @SerialName("product_brand") val productBrand: String,
    @SerialName("product_category") val productCategory: ProductCategory,
    @SerialName("product_description") val productDescription: String,
    @SerialName("product_name") val productName: String,
    @SerialName("product_price") val productPrice: Double,
    @SerialName("product_rating") val productRating: Double
)

