package ex2

import ex2.VarUtils.showVars

class Foo(a: Int, var b: String, val c: Int, d: Double) {
    @get:DontRead
    var n = "HIDDEN"
    val x: String = "ISEL"
    var y: Int = 2023
    private var z: Double = d * 2
}

fun main() {
    val obj = Foo(1000, "LEIC", 888, 3.14159)
    showVars(obj)
}
