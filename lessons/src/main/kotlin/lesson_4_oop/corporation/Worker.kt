package lesson_4_oop.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    private var salary: Int = 15000,
    val position: Position
) {

    fun getSalary() = this.salary

    fun setSalary(salary: Int) {
        if (salary < this.salary) {
            println("The new salary is to small...")
        } else {
            this.salary = salary
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
