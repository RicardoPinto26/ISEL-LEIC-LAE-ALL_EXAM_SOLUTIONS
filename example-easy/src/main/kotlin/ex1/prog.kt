package ex1

data class Message(val txt: String)
class Printer {
    fun writeln(msg: Message) {
        println(msg.txt)
    }
}

val out = Printer()
fun main() {
    out.writeln(Message("Hello"))
}
