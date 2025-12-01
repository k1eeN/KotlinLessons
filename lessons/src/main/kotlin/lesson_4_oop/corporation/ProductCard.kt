package lesson_4_oop.corporation

abstract class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val productType: ProductType
) {

    abstract fun printInfo()
}
