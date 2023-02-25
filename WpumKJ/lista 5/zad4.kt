
fun preambula(i: Int, Lista: List<Int>): Int 
{
    val listPre = Lista.windowed(i, 1)
    listPre.forEachIndexed {index, list ->
        val addList = Lista[i + index]
        if (list.find {addList - it in list} == null) 
        {
            return addList
        }
    }
    return 0

}

fun main()
{
  println(preambula(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))
}