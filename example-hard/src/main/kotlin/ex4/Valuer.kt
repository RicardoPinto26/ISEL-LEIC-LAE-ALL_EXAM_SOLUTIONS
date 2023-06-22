package ex4

interface Valuer {
    // a)
    fun estimate(a: String): Int

    // b)
    fun f(a: String): Int {
        return (estimate(a) + 2) / 5
    }
}