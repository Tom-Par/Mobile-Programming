fun fib(i: Int): Int {
    tailrec fun fibn(n: Int, a: Int, b: Int): Int {
        if (n==0) return a;
        else if (n==1) return b;
        else return fibn(n-1,b,a+b);
    }
    return fibn(i, 0, 1)
}

fun main() {
    println(fib(3))
}