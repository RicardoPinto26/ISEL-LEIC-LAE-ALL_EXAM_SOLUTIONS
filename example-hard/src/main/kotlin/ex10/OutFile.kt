package ex10

import java.io.Closeable
import java.io.FileOutputStream
import java.io.OutputStream

class OutFile(path: String) : Closeable {
    private var out: OutputStream? = FileOutputStream(path)
    fun write(msg: String) = out?.write(msg.toByteArray())
    override fun close() = cleanup()
    protected fun finalize() = cleanup()
    private fun cleanup() {
        println("cleanup started")
        out!!.close()
        out = null
        println("cleanup ended without exceptions")
    }
}
