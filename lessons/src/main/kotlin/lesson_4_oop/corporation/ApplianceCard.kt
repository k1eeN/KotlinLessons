package lesson_4_oop.corporation

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int
) : ProductCard(name, brand, price) {

    override fun printInfo() {
        println("Name: $name Brand: $brand Price: $price Wattage: $wattage")
    }
}
