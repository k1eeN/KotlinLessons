package lesson_4_oop.corporation

data class Accountant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) : Worker(
    id,
    name,
    age,
    salary,
    Position.ACCOUNTANT
), Cleaner, Supplier {

    private val workersRepository = WorkersRepository
    private val productCardRepository = ProductCardRepository

    override fun clean() {
        println("Accountant: I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("Accountant: I'm buying things...")
    }

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
                OperationCode.EXIT -> {
                    workersRepository.saveChanges()
                    productCardRepository.saveChanges()
                    break
                }
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEES -> registerNewEmployees()
                OperationCode.FIRE_EMPLOYEES -> fireAnEmployees()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
                OperationCode.CHANGE_AGE -> changeAge()
            }
        }
    }

    private fun changeAge() {
        print("Enter employee's id to change age: ")
        val id = readln().toInt()
        print("Enter new age: ")
        val age = readln().toInt()
        workersRepository.changeAge(id, age)
    }

    private fun changeSalary() {
        print("Enter employee's id to change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val salary = readln().toInt()
        workersRepository.changeSalary(id, salary)
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
        print("Enter salary: ")
        val salary = readln().toInt()
        val worker = when (position) {
            Position.DIRECTOR -> Director(id, name, age, salary)
            Position.ACCOUNTANT -> Accountant(id, name, age, salary)
            Position.ASSISTANT -> Assistant(id, name, age, salary)
            Position.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployees(worker)
    }

    override fun copy(
        id: Int,
        name: String,
        age: Int,
        salary: Int,
        position: Position
    ): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    private fun fireAnEmployees() {
        print("Enter employee's id to fire: ")
        val id = readln().toInt()
        workersRepository.fireAnEmployees(id)
    }

    private fun showAllEmployees() {
        val employees = workersRepository.workers
        for (employee in employees) {
            employee.printInfo()
        }
    }


    private fun removeProductCard() {
        print("Enter name of card for removing: ")
        val name = readln()
        productCardRepository.removeProductCard(name)
    }

    private fun showAllItems() {
        val cards = productCardRepository.productCards
        for (card in cards) {
            card.printInfo()
        }
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
                FoodCard(productName, productBrand, productPrice, caloric)
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(productName, productBrand, productPrice, wattage)
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                ShoeCard(productName, productBrand, productPrice, size)

            }
        }
        productCardRepository.registerNewItem(card)
    }
}
