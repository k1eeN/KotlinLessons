package lesson_81_sequence

import kotlin.random.Random

fun main() {
    var filterCount = 0
    var mapCount = 0

    sequence {
        println("Start generation")
        yield(0)
        println("Generate random numbers")
        repeat(100) {
            yield(Random.nextInt(1000))
        }
    }.filter {
        println("Filter")
        filterCount++
        it % 2 == 0
    }.map {
        println("Map")
        mapCount++
        it * 10
    }.take(10).count()

    println("Filtered: $filterCount")
    println("Mapped: $mapCount")
}