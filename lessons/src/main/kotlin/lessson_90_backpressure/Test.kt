package lessson_90_backpressure

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)


fun main() {
    //Producer
    val flow = flow {
        repeat(100) {
            println("Emitted: $it")
            emit(it)
            println("After emit: $it")
            delay(100)
        }
    }.buffer(100)
    //Consumer
    scope.launch {
        flow.collect {
            println("Collected: $it")
            delay(1000)
            println(it)
        }
    }

}