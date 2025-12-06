package lesson_35_design_patterns.users

class Administrator {

    private val repository = UsersRepository.getInstance("qwerty")

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
                Operation.ADD_USER -> addUser()
                Operation.DELETE_USER -> deleteUser()
            }
        }
    }

    fun addUser() {
        print("Enter first name: ")
        val firstName = readln()
        print("Enter last name: ")
        val lastName = readln()
        print("Enter age: ")
        val age = readln().toInt()
        UsersInvoker.addCommand {
            repository.addUser(firstName, lastName, age)
        }
    }

    fun deleteUser() {
        print("Enter id: ")
        val id = readln().toInt()
        UsersInvoker.addCommand {
            repository.deleteUser(id)
        }

    }
}