package lesson_25_working_with_data.product

import lesson_25_working_with_data.profile.ProfileRepository

fun main() {
    val products = ProductsRepository.products
    for (product in products) {
        println(product)
    }
}