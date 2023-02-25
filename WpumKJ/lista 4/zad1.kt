fun main() {
    
    val repeatWord = {s: String, i: Int -> var result :String = ""
        for (x in 1..i) result += s
        print(result)
    }

    repeatWord("a",4)
}

