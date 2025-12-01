package lesson_4_oop.corporation

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int
) : ProductCard(name, brand, price, ProductType.APPLIANCE) {

    override fun printInfo() {
        super.printInfo()
        println("Wattage: $wattage")
    }
}
