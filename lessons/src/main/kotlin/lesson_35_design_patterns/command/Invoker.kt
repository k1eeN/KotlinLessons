package lesson_35_design_patterns.command

interface Invoker {

    fun addCommand(command: Command)
}