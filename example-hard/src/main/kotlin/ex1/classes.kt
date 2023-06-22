package ex1

import java.io.Closeable

interface Printable {
    fun printIt()
}

class Info(val code: Int, val text: String) : Printable, Closeable {
    override fun printIt() {
        println("Info($code) { text: \"$text\"}")
    }

    override fun close() {
        println("Info($code) -- Done")
    }
}

fun texts() = sequence { yield("ISEL"); yield("LEIC"); yield("LAE") }
fun main() {
    var count = 1
    texts().map { Info(count++, it) }.forEach { it.use { info -> info.printIt() } }
}
