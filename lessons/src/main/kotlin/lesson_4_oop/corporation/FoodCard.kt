package lesson_4_oop.corporation

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
) : ProductCard(name, brand, price) {

    override fun printInfo() {
        println("Name: $name Brand: $brand Price: $price Caloric: $caloric")
    }
}
