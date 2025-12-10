package lesson_82_flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

private var lastIndex = 0

private suspend fun loadNext(): List<String> {
    delay(2000)
    return (lastIndex..<(lastIndex + 10))
        .map { "Video: $it" }
        .also {
            lastIndex += 10
            println("Loaded: ${it.joinToString()}")
        }
}

private suspend fun scroll(videos: List<String>) {
    delay(videos.size * 100L)
    println("Scrolled ${videos.joinToString()}")
}


private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)


fun main() {

    scope.launch {
        flow {
            repeat(10) {
                val nextData = loadNext()
                emit(nextData)
            }
        }.collect { scroll(it) }
    }

}