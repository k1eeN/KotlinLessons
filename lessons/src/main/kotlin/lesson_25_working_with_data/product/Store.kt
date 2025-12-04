package lesson_25_working_with_data.product

import lesson_25_working_with_data.profile.ProfileRepository

fun main() {
    val products = ProductsRepository.products

    var filtered = filter(products, object : Condition {
        override fun isSuitable(productCard: ProductCard): Boolean {
            return productCard.productPrice > 500
        }
    })
    filtered = filter(filtered, object : Condition {
        override fun isSuitable(productCard: ProductCard): Boolean {
            return productCard.productRating > 4
        }
    })
    filtered = filter(filtered, object : Condition {
        override fun isSuitable(productCard: ProductCard): Boolean {
            return productCard.productCategory == ProductCategory.SPORTS
        }
    })

    for (product in filtered) {
        println(product)
    }
}

fun filter(products: List<ProductCard>, condition: Condition): List<ProductCard> {
    val result = mutableListOf<ProductCard>()
    for (productCard in products) {
        if (condition.isSuitable(productCard)) {
            result.add(productCard)
        }
    }
    return result
}