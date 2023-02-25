fun suma(a: Array<Int>): Int {
    val r = a.map {it}.filter {it<0}.reduce {
        res, elem -> res + elem
    }
    return r
}

fun main() {
    val a : Array<Int> = arrayOf(1, 3,-12,-33,0,100,-320)
    println(suma(a))
}