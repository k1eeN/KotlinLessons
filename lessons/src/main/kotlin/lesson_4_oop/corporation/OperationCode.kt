package lesson_4_oop.corporation

enum class OperationCode(val title: String) {
    EXIT("Exit"),

    REGISTER_NEW_ITEM("Register new item"),

    SHOW_ALL_ITEMS("Show all items"),

    REMOVE_PRODUCT_CARD("Remove product card")
}
