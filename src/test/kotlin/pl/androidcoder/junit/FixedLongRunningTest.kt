package pl.androidcoder.junit

import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test

class FixedLongRunningTest {

    companion object {
        private var testData: List<TestData>? = null
        private var startTime : Long = 0
        @JvmStatic
        @BeforeClass
        fun setUpClass() {
            startTime = System.currentTimeMillis()
            testData = TestDataProvider().getData()
        }

        @JvmStatic
        @AfterClass
        fun tearDownClass() {
            println("Clear data")
            println("exectuion time = ${System.currentTimeMillis() - startTime}ms")
            testData = null
        }
    }

    @Test
    fun test1() {
        println("test1")
        Assert.assertNotNull(testData)
    }

    @Test
    fun test2() {
        println("test2")
        Assert.assertNotNull(testData)
    }

    @Test
    fun test3() {
        println("test3")
        Assert.assertNotNull(testData)
    }

    @Test
    fun test4() {
        println("test4")
        Assert.assertNotNull(testData)
    }
}