package ex4

import kotlin.random.Random

fun win(obj: Any) = obj
fun yyy(): Any {
    val n: Int = Random.nextInt()
    val obj = win(n)
    val p = obj as Int?
    val res = p!!
    return res + n.hashCode()
}
