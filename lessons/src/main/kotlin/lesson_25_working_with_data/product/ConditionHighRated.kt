package lesson_25_working_with_data.product

class ConditionHighRated : Condition {
    override fun isSuitable(productCard: ProductCard): Boolean {
        return productCard.productRating > 4
    }
}