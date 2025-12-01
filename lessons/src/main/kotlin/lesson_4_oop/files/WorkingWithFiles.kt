package lesson_4_oop.files

import java.io.File

fun main() {
    val operationCodes = OperationCode.entries
    while (true) {
        print("Enter the operation code. ")
        for ((index, code) in operationCodes.withIndex()) {
            print("$index - ${code.title}; ")
        }
        val operationIndex = readln().toInt()
        val operationCode = operationCodes[operationIndex]
        when (operationCode) {
            OperationCode.EXIT -> break
            OperationCode.ADD_NEW_ITEM -> addNewItem()
            OperationCode.SHOW_ALL -> showAllItems()
        }

    }
}

fun addNewItem() {
    val file = File("todo_list.txt")
    print("Enter a new item: ")
    file.appendText("${readln()}\n")
}

fun showAllItems() {
    val file = File("todo_list.txt")
    val content = file.readText().trim()
    val items = content.split("\n")
    for ((index, item) in items.withIndex()) {
        println("$index - $item")
    }
}
