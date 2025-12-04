package lesson_25_working_with_data.product


fun main() {
    val products = ProductsRepository.products

    val filtered = filter(products) {
        it.productCategory == ProductCategory.CLOTHING
    }
    val transformed = transform(filtered) {
        it.copy(productPrice = it.productPrice * 2)
    }
    val productsName = transform(transformed) {
        "${it.id} - ${it.productName} - ${it.productPrice}"
    }

    for (product in productsName) {
        println(product)
    }
}

fun <T> transform (products: List<ProductCard>, operation: (ProductCard) -> T): List<T> {
    val result = mutableListOf<T>()
    for (productsCard in products) {
        result.add(operation(productsCard))
    }
    return result
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