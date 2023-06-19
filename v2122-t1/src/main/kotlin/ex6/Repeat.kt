package ex6

fun <T : Any> Sequence<T>.repeat(times: Int): Sequence<T> = sequence {
    this@repeat.forEach {
        repeat(times) { _ ->
            yield(it)
        }
    }
}


fun main() {
    val a = sequenceOf(3, 5, 1, 5).repeat(3)

    a.forEach {
        print("$it, ")
    }
}