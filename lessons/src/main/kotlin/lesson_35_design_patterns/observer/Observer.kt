package lesson_35_design_patterns.observer

import lesson_35_design_patterns.users.User

fun interface Observer<T> {

    fun onChanged(newValue: T)
}