package ex8

fun main() {
    val nrs = arrayOf("abc", "def", "super").map { print("$it "); it.length }
    println(nrs.distinct().count())
    println(nrs.count())

}