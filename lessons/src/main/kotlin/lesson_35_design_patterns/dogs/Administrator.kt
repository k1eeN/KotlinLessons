package lesson_35_design_patterns.dogs


class Administrator {

    private val repository = DogsRepository.getInstance("qwerty")

    fun work() {
        while (true) {
            print("Enter an operation: ")
            val operations = Operation.entries
            for ((index, operation) in operations.withIndex()) {
                print("$index - ${operation.title}")
                if (index == operations.lastIndex) {
                    print(": ")
                } else {
                    print(", ")
                }
            }
            val operationIndex = readln().toInt()
            val operation = operations[operationIndex]
            when (operation) {
                Operation.EXIT -> {
                    repository.saveChanges()
                    break
                }
                Operation.ADD_DOG -> addDog()
                Operation.DELETE_DOG -> deleteDog()
            }
        }
    }

    fun addDog() {
        print("Enter breed: ")
        val breed = readln()
        print("Enter name: ")
        val name = readln()
        print("Enter wight: ")
        val wight = readln().toDouble()
        repository.addDog(breed, name, wight)
    }

    fun deleteDog() {
        print("Enter id: ")
        val id = readln().toInt()
        repository.deleteDog(id)
    }
}