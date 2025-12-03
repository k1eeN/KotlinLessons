package lesson_4_oop.corporation

fun main() {
    val workers = WorkersRepository.workers
    for (worker in workers) {
        worker.work()
    }
}
