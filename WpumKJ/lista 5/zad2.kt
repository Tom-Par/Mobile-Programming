fun sortow(a: List<String>) {
    val res = a.sorted().filter {it -> it.length%2==0}.groupBy {it.first()}.toList()
    println(res)
}

fun main() {
    sortow(listOf("cherry","blueberry","citrus","apple","apricot","banana","coconut"))
}