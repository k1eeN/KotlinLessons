package lesson_65_coroutines.exeptions

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors


private val exceptionHandler = CoroutineExceptionHandler { _, _ -> println("Exception caught") }
private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope =
    CoroutineScope(dispatcher + CoroutineName("My Coroutine") + Job() + exceptionHandler)

fun main() {
    scope.launch {
        method()
    }
}

suspend fun method() {
    delay(3000)
    error("")
}