fun liczby(a: List<Number>) : List<Number> {
    val res = a.filterIndexed { index, number -> index%2!=0 && number.toDouble() > 0}
    return res
     
} 

fun main() {
    val list = liczby(listOf(1,2,3.5,5,-6,1,1))
    for(i in list) {
        val num = Math.pow(i.toDouble(),2.0).toInt()
        println(num)
    }
}