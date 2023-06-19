package ex3

fun checkAndSet(instance: Any, fieldName: String, value: String) {
    val field = instance.javaClass.getDeclaredField(fieldName)
    println(field.annotations)
    if(!field.isAnnotationPresent(ValidText::class.java)) throw IllegalAccessError()
    val annotation = field.getAnnotation(ValidText::class.java) ?: throw IllegalArgumentException()
    val allowedTexts = annotation.validTexts
    if(value !in allowedTexts) {
        throw IllegalArgumentException("value not in annotation")
    }

    field.set(instance, value)
}

fun main() {
    val weather = Weather()
    println(weather.desc)
    checkAndSet(weather, "desc", "Cloudy")
    println(weather.desc)
}