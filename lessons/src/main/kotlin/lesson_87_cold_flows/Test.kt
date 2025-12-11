package lesson_87_cold_flows

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)

private val repository = Repository

fun main() {
    val flow = repository.timer
    scope.launch {
        flow.collect {
            println(it)
        }
    }
    scope.launch {
        flow.collect {
            println(it)
        }
    }
}

