package lesson_4_oop.corporation

fun main() {
    val accountant = Accountant(0,"John", 27)
    val employees = accountant.loadAllEmployees()
    for (employee in employees) {
        if (employee is Cleaner) {
            employee.clean()
        }
        if (employee is Supplier) {
            employee.buyThings()
        }
    }
}
