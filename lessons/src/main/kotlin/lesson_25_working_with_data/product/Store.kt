package lesson_25_working_with_data.product

fun main() {
    ProductsRepository.products
        .also { println("Filter by category CLOTHING") }
        .filter { it.productCategory == ProductCategory.CLOTHING }
        .also { println("Increase price") }
        .map { it.copy(productPrice = it.productPrice * 2) }
        .also { println("Convert to String") }
        .map { "${it.id} - ${it.productName} - ${it.productPrice}" }
        .also { println("Print info") }
        .forEach(::println)
}