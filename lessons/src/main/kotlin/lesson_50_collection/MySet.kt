package lesson_50_collection

interface MySet<T> : MyCollection<T> {

    override val size: Int

    override fun contains(element: T): Boolean
}