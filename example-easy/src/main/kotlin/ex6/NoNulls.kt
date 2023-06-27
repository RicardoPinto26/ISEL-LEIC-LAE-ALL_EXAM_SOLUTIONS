package ex6

fun <T : Any> Sequence<T?>.noNulls(): Sequence<T> = sequence {
    this@noNulls.forEach {
        if (it != null) yield(it)
    }
}