package lesson_4_oop.corporation

import java.io.File

class Accountant(
    id: Int,
    name: String,
    age: Int
) : Worker(id, name, age, Position.ACCOUNTANT) {

    private val fileProductCard = File("product_cards.txt")
    private val fileWorkers = File("workers.txt")

    override fun work() {
        val operationCodes = OperationCode.entries
        while (true) {
            println("Enter the operation code. ")
            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}\n")
            }
            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEES -> registerNewEmployees()
                OperationCode.FIRE_EMPLOYEES -> fireAnEmployees()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
            }
        }
    }

    private fun registerNewEmployees() {
        val positions = Position.entries
        print("Choose position - ")
        for ((index, position) in positions.withIndex()) {
            print("$index - ${position.title}")
            if (index < positions.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val positionIndex = readln().toInt()
        val position = positions[positionIndex]
        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        val worker = when (position) {
            Position.DIRECTOR -> Director(id, name, age)
            Position.ACCOUNTANT -> Accountant(id, name, age)
            Position.ASSISTANT -> Assistant(id, name, age)
            Position.CONSULTANT -> Consultant(id, name, age)
        }
        saveWorkerToFile(worker)
    }

    private fun fireAnEmployees() {
        print("Enter employee's id to fire: ")
        val id = readln().toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees) {
            if (employee.id != id) {
                saveWorkerToFile(employee)
            }
        }
    }

    private fun showAllEmployees() {
        val employees = loadAllEmployees()
        for (employee in employees) {
            employee.printInfo()
        }
    }

    private fun loadAllEmployees(): MutableList<Worker> {
        val employees = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()

        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for (employeesAsText in employeesAsText) {
            val properties = employeesAsText.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val positionAsText = properties.last()
            val position = Position.valueOf(positionAsText)
            val worker = when (position) {
                Position.DIRECTOR -> Director(id,name,age)
                Position.ACCOUNTANT -> Accountant(id,name,age)
                Position.ASSISTANT -> Assistant(id,name,age)
                Position.CONSULTANT -> Consultant(id,name,age)
            }
            employees.add(worker)
        }
        return employees
    }

    private fun saveWorkerToFile(worker: Worker) {
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.position}\n")
    }


    private fun removeProductCard() {
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Enter name of card for removing: ")
        val name = readln()
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

    private fun loadAllCards(): MutableList<ProductCard> {
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

    private fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards) {
            card.printInfo()
        }
    }

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

    private fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]

        print("Enter the product name: ")
        val productName = readln()

        print("Enter the product brand: ")
        val productBrand = readln()

        print("Enter the product price: ")
        val productPrice = readln().toInt()

        val card = when (productType) {
            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                FoodCard(productName,productBrand,productPrice,caloric)
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(productName,productBrand,productPrice,wattage)
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                ShoeCard(productName,productBrand,productPrice,size)

            }
        }
        saveProductCardToFile(card)
    }
}
