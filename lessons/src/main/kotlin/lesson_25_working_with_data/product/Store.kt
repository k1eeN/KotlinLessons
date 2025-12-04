package lesson_25_working_with_data.product


fun main() {
    val products = ProductsRepository.products
        .filter { it.productCategory == ProductCategory.CLOTHING }
        .transform { it.copy(productPrice = it.productPrice * 2) }
        .transform { "${it.id} - ${it.productName} - ${it.productPrice}" }


    for (product in products) {
        println(product)
    }
}

fun <T> List<ProductCard>.transform (operation: (ProductCard) -> T): List<T> {
    val result = mutableListOf<T>()
    for (productsCard in this) {
        result.add(operation(productsCard))
    }
    return result
}

fun List<ProductCard>.filter(isSuitable: (ProductCard) -> Boolean): List<ProductCard> {
    val result = mutableListOf<ProductCard>()
    for (productCard in this) {
        if (isSuitable(productCard)) {
            result.add(productCard)
        }
    }
    return result
}