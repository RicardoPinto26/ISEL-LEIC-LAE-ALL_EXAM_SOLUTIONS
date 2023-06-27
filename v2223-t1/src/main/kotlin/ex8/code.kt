package ex8

// METODO ESTRANHO QUE FIZ NO EXAME
fun <T, K> Sequence<T>.coalesceEstranho(block: (T, T) -> K): Sequence<K> = sequence {
    var i = 0; var prevElem: T? = null
    this@coalesceEstranho.forEach { elem ->
        if (++i % 2 == 0)
            yield(block(prevElem!!, elem))
        else
            prevElem = elem
    }
}

// METODO NORMAL PARA FAZER ISTO
fun <T, K> Sequence<T>.coalesceNormal(block: (T, T) -> K): Sequence<K> = sequence {
    val iterator = this@coalesceNormal.iterator()
    while (iterator.hasNext()) {
        val elem1 = iterator.next()
        if (iterator.hasNext())
            yield(block(elem1, iterator.next()))
    }
}

fun main() {
    sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9).coalesceEstranho { a, b -> (a + b) / 2.0 }.forEach { print("$it ") }
    println()
    sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9).coalesceNormal { a, b -> (a + b) / 2.0 }.forEach { print("$it ") }
}