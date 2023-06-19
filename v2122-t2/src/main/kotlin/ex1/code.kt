package ex1

import kotlin.math.max

val e = 2.718281828
val pi = 3.141592654

interface F {
    fun op(arg: Double): Double
}

object Stats {
    var maxOffset = 0.0
}

class A : F {
    override fun op(arg: Double): Double {
        return arg
    }
}

class B(private val offset: Double) : F {
    init {
        Stats.maxOffset = max(Stats.maxOffset, offset)
    }

    override fun op(arg: Double): Double {
        return arg
    }
}
