package lesson_4_oop.corporation

abstract class ProductCard(
    open val name: String,
    open val brand: String,
    open val price: Int,
    val productType: ProductType
) {

    fun printInfo() {
        println(this)
    }
}
