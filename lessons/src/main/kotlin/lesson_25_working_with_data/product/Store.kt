package lesson_25_working_with_data.product

import lesson_25_working_with_data.profile.ProfileRepository

fun main() {
    val products = ProductsRepository.products

    var filtered = filter(products) { it.productPrice > 500 }
    filtered = filter(filtered) { it.productRating > 4 }
    filtered = filter(filtered) { it.productCategory == ProductCategory.SPORTS }

    for (product in filtered) {
        println(product)
    }
}

fun filter(products: List<ProductCard>, isSuitable: (ProductCard) -> Boolean): List<ProductCard> {
    val result = mutableListOf<ProductCard>()
    for (productCard in products) {
        if (isSuitable(productCard)) {
            result.add(productCard)
        }
    }
    return result
}