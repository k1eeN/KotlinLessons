package lesson_35_design_patterns.dogs

import lesson_35_design_patterns.command.Command
import lesson_35_design_patterns.command.Invoker
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

object DogsInvoker : Invoker<AdministratorCommands> {
    private val commands = LinkedBlockingQueue<Command>()

    init {
        thread {
            while (true) {
                println("Waiting")
                val command = commands.take()
                println("Executing $command...")
                command.execute()
                println("Executed $command")
            }
        }
    }

    override fun addCommand(command: AdministratorCommands) {
        println("New command: $command")
        commands.add(command)
    }
}