package lesson_4_oop.corporation

import java.io.File

class ProductCardRepository {


    private val fileProductCard = File("product_cards.txt")


    fun loadAllCards(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf()

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
        val cards: MutableList<ProductCard> = loadAllCards()
        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        fileProductCard.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    fun registerNewItem(productCard: ProductCard) = saveProductCardToFile(productCard)

    private fun saveProductCardToFile(productCard: ProductCard) {
        fileProductCard.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                print("Enter the caloric: ")
                val caloric = productCard.caloric
                fileProductCard.appendText("$caloric%")
            }

            is ApplianceCard -> {
                print("Enter the wattage: ")
                val wattage = productCard.wattage
                fileProductCard.appendText("$wattage%")
            }

            is ShoeCard -> {
                print("Enter the size: ")
                val size = productCard.size
                fileProductCard.appendText("$size%")
            }
        }
        fileProductCard.appendText("${productCard.productType}\n")
    }
}