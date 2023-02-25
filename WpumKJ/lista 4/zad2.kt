// val f : (String) -> String = { s:String -> s + "!" }

fun main() {
    val f : (String) -> String = { it + "!" }
    print(f("kotlin"))
}