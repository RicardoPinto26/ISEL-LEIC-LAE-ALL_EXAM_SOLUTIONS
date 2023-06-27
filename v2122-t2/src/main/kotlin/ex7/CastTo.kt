package ex7

import java.time.LocalDate

inline fun <reified T> List<Any>.castTo(): List<T> =
    this.map {
        it as T
    }


fun main() {
    val objs1: List<Any> = listOf(1, 2, 3, 4, 5)
    val objs2: List<Any> = listOf(LocalDate.of(2022, 7, 15), "2022-6-29")
    val nbrs: List<Int> = objs1.castTo<Int>() // OK
    val strs: List<LocalDate> = objs2.castTo<LocalDate>() // throws Exception
}