fun <T> List<T>.head(): T {return this[0]}

fun <T> List<T>.tail(): List<T> {return this.drop(1)}

fun main() {
    val list : List<Int> = listOf(1,2,3,4,5,6,7,8)
    println(list.head())
    println(list.tail())
}
