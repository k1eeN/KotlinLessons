package lesson_4_oop.corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
) : ProductCard(name, brand, price) {

    override fun printInfo() {
        println("Name: $name Brand: $brand Price: $price Size: $size")
    }
}
