package lesson_25_working_with_data.product

class ConditionSport : Condition {
    override fun isSuitable(productCard: ProductCard): Boolean {
        return productCard.productCategory == ProductCategory.SPORTS
    }
}