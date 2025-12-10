package lesson_65_coroutines.cancellation

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)

fun main() {

    val job = scope.launch {
        timer()
    }
    Thread.sleep(3000)
    job.cancel()
}


suspend fun timer() {
    withContext(dispatcher) {
        var seconds = 0
        while (true) {
            try {
                ensureActive()
                println(seconds++)
                Thread.sleep(1000)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
            }
        }
    }

}