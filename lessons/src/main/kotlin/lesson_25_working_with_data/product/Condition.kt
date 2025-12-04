package lesson_25_working_with_data.product

interface Condition {

    fun isSuitable(productCard: ProductCard): Boolean
}