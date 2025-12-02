package lesson_4_oop.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: Position
) {

    var salary = 15000
        set(value) {
            if (value < field) {
                println("The new salary is to small...")
            } else {
                field = value
            }

        }

    abstract fun work()



    open fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $position Salary: $salary"
    }

}
