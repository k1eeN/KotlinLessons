package lesson_4_oop.corporation

import java.io.File

object ProductCardRepository {


    private val fileProductCard = File("product_cards.txt")

    private val _productCards = loadAllCards()
    val productCards
        get() = _productCards.toList()

    fun registerNewItem(productCard: ProductCard) = _productCards.add(productCard)

    fun saveChanges() {
        val content = StringBuilder()
        for (productCard in _productCards) {
            content.append("${productCard.name}%${productCard.brand}%${productCard.price}%")
            when (productCard) {
                is FoodCard -> {
                    print("Enter the caloric: ")
                    val caloric = productCard.caloric
                    content.append("$caloric%")
                }

                is ApplianceCard -> {
                    print("Enter the wattage: ")
                    val wattage = productCard.wattage
                    content.append("$wattage%")
                }

                is ShoeCard -> {
                    print("Enter the size: ")
                    val size = productCard.size
                    content.append("$size%")
                }
            }
            content.append("${productCard.productType}\n")
        }
        fileProductCard.writeText(content.toString())
    }

    private fun loadAllCards(): MutableSet<ProductCard> {
        val cards: MutableSet<ProductCard> = mutableSetOf()

        if (!fileProductCard.exists()) fileProductCard.createNewFile()
        val content = fileProductCard.readText().trim()

        if (content.isEmpty()) {
            return cards
        }

        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    fun removeProductCard(name: String) {
        for (card in _productCards) {
            if (card.name == name) {
                _productCards.remove(card)
                break
            }
        }
    }
}