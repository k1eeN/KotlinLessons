package lesson_35_design_patterns.command

interface Invoker<T : Command> {

    fun addCommand(command: T)
}