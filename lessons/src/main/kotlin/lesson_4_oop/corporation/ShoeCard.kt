package lesson_4_oop.corporation

data class ShoeCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val size: Float
) : ProductCard(name, brand, price, ProductType.SHOE)
