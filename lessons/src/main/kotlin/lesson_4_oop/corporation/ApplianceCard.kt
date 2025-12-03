package lesson_4_oop.corporation

data class ApplianceCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val wattage: Int
) : ProductCard(name, brand, price, ProductType.APPLIANCE)
