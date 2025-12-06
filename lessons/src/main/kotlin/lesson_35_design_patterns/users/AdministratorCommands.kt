package lesson_35_design_patterns.users

import lesson_35_design_patterns.command.Command

sealed interface AdministratorCommands : Command {

    data class AddUser(
        val repository: UsersRepository,
        val firsName: String,
        val lastName: String,
        val age: Int,
    ) : AdministratorCommands {

        override fun execute() {
            repository.addUser(firsName, lastName, age)
        }
    }

    data class DeleteUser(
        val repository: UsersRepository,
        val id: Int,
    ) : AdministratorCommands {

        override fun execute() {
            repository.deleteUser(id)
        }
    }


    data class SaveChanges(
        val repository: UsersRepository
    ) : AdministratorCommands {

        override fun execute() {
            repository.saveChanges()
        }
    }
}