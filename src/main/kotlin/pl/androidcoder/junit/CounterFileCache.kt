package pl.androidcoder.junit

import java.io.File
import java.nio.ByteBuffer


class CounterFileCache(private val cacheDir: String) {
    companion object {
        private const val COUNTER_FILENAME = "counter_cache.txt"
    }

    fun saveCounter(counter: Int) {
        val bytes = ByteBuffer.allocate(4).putInt(counter).array()
        getFile().writeBytes(bytes)
    }

    fun getCounter(): Int {
        val bytes = getFile().readBytes()
        return if (bytes.isNotEmpty())
            ByteBuffer.wrap(bytes).int
        else
            0
    }

    private fun getFile(): File {
        val file = File("$cacheDir$COUNTER_FILENAME")
        val directory = file.parentFile

        if (!directory.exists() && !directory.mkdirs()) {
            throw IllegalStateException("Couldn't create dir: $directory")
        }
        if (!file.exists() && !file.createNewFile()) {
            throw IllegalStateException("Couldn't create file: $file")
        }
        return file
    }
}