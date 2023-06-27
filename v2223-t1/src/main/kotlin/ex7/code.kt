package ex7

fun main() {
    println("COM ARRAY")
    val res1 = arrayOf("abcdef", "super", "isel", "trio", "tri")
        .map { print("$it "); it.length }
        .filter { print("$it "); it % 2 == 0 }
        .distinct()
    print("\n res1 = "); println(res1)

    println("COM SEQUENCE")
    val res2 = sequenceOf("abcdef", "super", "isel", "trio", "tri")
        .map { print("$it "); it.length }
        .filter { print("$it "); it % 2 == 0 }
        .distinct()
    print("\n res2 = "); println(res2)
}