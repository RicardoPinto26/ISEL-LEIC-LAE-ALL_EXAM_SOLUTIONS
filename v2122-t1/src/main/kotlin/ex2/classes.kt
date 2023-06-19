package ex2

import kotlin.math.sqrt

class A(
    val x: Int,
    val y: Int
) {
    fun modulus(): Float =
        sqrt(x.toFloat() * x + y * y)
}

class B(
    val x: Int,
    val y: Int,
    var modulus: Float = 0.0F
)

class C(
    x: Int,
    y: Int,
    val modulus: Float =
        sqrt(x.toFloat() * x + y * y)
)
