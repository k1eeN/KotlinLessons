package lesson_25_working_with_data.product

class ConditionExpensive : Condition {
    override fun isSuitable(productCard: ProductCard): Boolean {
        return productCard.productPrice > 500
    }
}