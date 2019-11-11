package pl.androidcoder.junit

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File


class TestCounterFileCache {

    companion object {
        private const val COUNTER_FILENAME = "counter_cache.txt"
    }

    private val cacheDir = "out/test/cache/${hashCode()}/"

    private val counterFileCache = CounterFileCache(cacheDir)

    @Test
    fun `counter should saved into file`() {
        //WHEN
        val expectedCounter = 23
        counterFileCache.saveCounter(expectedCounter)
        //THEN
        assertCounterFromFile(expectedCounter)
    }

    @Test
    fun `when counter saved then get counter should return the same number`() {
        //GIVEN
        val expectedCounter = 12
        //WHEN
        counterFileCache.saveCounter(expectedCounter)
        //THEN
        assertEquals(expectedCounter, counterFileCache.getCounter())
    }

    @Test
    fun `when counter not exist then return 0`() {
        assertEquals(0, counterFileCache.getCounter())
    }

    @After
    fun tearDown() {
        File(cacheDir).deleteRecursively()
    }

    private fun assertCounterFromFile(expectedCounter: Int) {
        val file = File("$cacheDir$COUNTER_FILENAME")
        assert(file.exists())
        val counterFileReader = CounterFileCache(cacheDir)
        assertEquals(expectedCounter, counterFileReader.getCounter())
    }
}

