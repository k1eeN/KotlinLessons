package lesson_89_shareIn

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

object Repository {

    private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
    private val scope = CoroutineScope(dispatcher)

    private val _timer = MutableSharedFlow<Int>()
    val timer
        get() = _timer.asSharedFlow()

    init {
        scope.launch {
            var seconds = 0
            while (true) {
                _timer.emit(seconds++)
                delay(1000)
            }
        }
    }

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