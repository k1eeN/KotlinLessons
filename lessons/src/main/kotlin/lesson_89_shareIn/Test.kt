package lesson_89_shareIn

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)

private val repository = Repository2

fun main() {
    val flow = repository.timer
    scope.launch {
        flow.collect {
            println("Coroutine 1: $it")
        }
    }
    scope.launch {
        delay(5000)
        flow.collect {
            println("Coroutine 2: $it")
        }
    }
}

