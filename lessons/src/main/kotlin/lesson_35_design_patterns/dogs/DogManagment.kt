package lesson_35_design_patterns.dogs



fun main() {
    DogsRepository.getInstance("qwerty").dogs.forEach(::println)
}