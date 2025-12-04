package lesson_35_design_patterns.users

fun main() {
    UsersRepository.getInstance("qwerty").users.forEach(::println)
}