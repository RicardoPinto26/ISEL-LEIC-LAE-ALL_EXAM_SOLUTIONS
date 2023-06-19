package ex7

inline fun <reified T> listOfDefaults(n: Int = 0): List<T> {
    val list = mutableListOf<T>()
    repeat(n) {
        list.add(T::class.java.constructors[0].newInstance() as T)
    }
    return list
}

class Student() {

}

class Person() {

}

fun main() {
    val list1 = listOfDefaults<Student>(3)
    val list2: List<Person> = listOfDefaults(2)
// ...
}
