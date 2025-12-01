package lesson_4_oop.corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
) : ProductCard(name, brand, price, ProductType.SHOE) {

    override fun printInfo() {
        super.printInfo()
        println("Size: $size")
    }
}
