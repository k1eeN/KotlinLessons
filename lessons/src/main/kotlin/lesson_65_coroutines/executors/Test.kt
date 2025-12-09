package lesson_65_coroutines.executors

import java.util.concurrent.Executors


fun main() {
    val executorService = Executors.newFixedThreadPool(1000)
    repeat(10_000) {
        executorService.execute {
            progressImage(Image(it))
        }
    }

}

private fun progressImage(image: Image) {
    println("Image $image is processing")
    Thread.sleep(1000)
    println("Image $image is processed")
}

data class Image(val id: Int)