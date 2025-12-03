package lesson_4_oop.corporation

fun main() {
    val assistant = WorkersRepository.findAssistant()
    assistant?.printInfo()
    val director = WorkersRepository.findDirector()
    director?.printInfo()
    if (assistant != null) {
        director?.takeCoffee(assistant)
    }

}
