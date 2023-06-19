package ex5

class Pack(val v: Any)

fun bar(): Int {
    val n = 6235
    val p = Pack(n)
    val res = p.v as Int?
    return res ?: 0
}