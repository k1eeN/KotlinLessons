package lesson_4_oop.profile

fun main() {
    print("Enter 1st name: ")
    val firstName = readln()

    print("Enter 2nd name: ")
    val secondName = readln()

    print("Enter 1st age: ")
    val firstAge = readln().toInt()

    print("Enter 2nd age: ")
    val secondAge = readln().toInt()

    print("Enter 1st height: ")
    val firstHeight = readln().toInt()

    print("Enter 2nd height: ")
    val secondHeight = readln().toInt()

    print("Enter 1st weight: ")
    val firstWeight = readln().toInt()

    print("Enter 2nd weight: ")
    val secondWeight = readln().toInt()

    val first = Person(name = firstName, age = firstAge, height = firstHeight, weight = firstWeight)
    val second =
        Person(name = secondName, age = secondAge, height = secondHeight, weight = secondWeight)

    first.printInfo()
    second.printInfo()
    first.sayHello()
    second.sayHello()
}
