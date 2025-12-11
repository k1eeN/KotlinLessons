package lesson_87_cold_flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Repository {

    val timer = getTimerFlows()

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