package lesson_89_shareIn

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import java.util.concurrent.Executors

object Repository2 {

    private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
    private val scope = CoroutineScope(dispatcher)

    val timer = getTimerFlows().shareIn(scope, SharingStarted.WhileSubscribed())

    private fun getTimerFlows(): Flow<Int> {
        return flow {
            var seconds = 0
            while (true) {
                emit(seconds++)
                delay(1000)
            }
        }
    }
}