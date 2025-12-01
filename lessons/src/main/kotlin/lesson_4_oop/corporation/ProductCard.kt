package lesson_4_oop.corporation

open class ProductCard(
    val name: String,
    val brand: String,
    val price: Int
) {

    open fun printInfo() {
        println("Name: $name Brand: $brand Price: $price")
    }
}
