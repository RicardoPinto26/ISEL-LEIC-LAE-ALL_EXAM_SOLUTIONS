package ex6

fun main() {
    sequenceOf("abc", "isel", "super")
    //arrayOf("abc", "isel", "super")
        .map { print("$it "); it.length }
        .filter { print("$it "); it == 4 }
        .first()
}