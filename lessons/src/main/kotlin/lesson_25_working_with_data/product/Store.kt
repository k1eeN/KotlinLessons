package lesson_25_working_with_data.product

fun main() {
    ProductsRepository.products
        .filter { it.productCategory == ProductCategory.CLOTHING }
        .map { it.copy(productPrice = it.productPrice * 2) }
        .map { "${it.id} - ${it.productName} - ${it.productPrice}" }
        .forEach { println(it) }
}