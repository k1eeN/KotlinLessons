package lesson_95_reified

import lesson_94_invariance_and_covariance.collections.MyArrayList
import lesson_94_invariance_and_covariance.collections.MyList
import lesson_94_invariance_and_covariance.collections.myListOf

fun main() {
    val workers = myListOf(Director("John"), Programmer("Nick"), Programmer("Max"))
    workers.myFilterIsInstance<Programmer>().forEach { it.writeCode() }
}


inline fun <reified R> MyList<*>.myFilterIsInstance(): MyList<R> {
    val result = MyArrayList<R>()
    for (element in this) {
        if (element is R) {
            result.add(element)
        }
    }
    return result
}

open class Worker(val name: String)

class Programmer(name: String) : Worker(name) {

    fun writeCode() {
        println("I'm writing the code")
    }
}

class Director(name: String) : Worker(name)