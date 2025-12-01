package lesson_4_oop.corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
) : ProductCard(name, brand, price, ProductType.SHOE) {

    override fun toString(): String {
        return "Name: $name Brand: $brand Price: $price Product Type: ${productType.title} Size: $size\n"
    }
}
