package ex5

inline fun <reified R> List<*>.weaklyCheckedAs(): List<R> {
    if (!isEmpty()) {
        first() as R
    }
    @Suppress("UNCHECKED_CAST")
    return this as List<R>
}