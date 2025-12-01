package lesson_4_oop.corporation

enum class OperationCode(val title: String) {
    EXIT("Exit"),

    REGISTER_NEW_ITEM("Register new item"),

    SHOW_ALL_ITEMS("Show all items"),

    REMOVE_PRODUCT_CARD("Remove product card"),

    REGISTER_NEW_EMPLOYEES("Register new employees"),

    FIRE_EMPLOYEES("Fire an employees"),

    SHOW_ALL_EMPLOYEES("Show all employees")
}
