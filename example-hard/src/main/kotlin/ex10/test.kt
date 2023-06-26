package ex10

fun func() {
    OutFile("./file.txt").close()
}

fun main() {
    try {
        func()
    } finally {
        System.gc()
        System.runFinalization()
    }
}
