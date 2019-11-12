package pl.androidcoder.junit

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LongRunningTest {

    private var testData: List<TestData>? = null
    @Before
    fun setUpClass() {
        testData = TestDataProvider().getData()
    }

    @After
    fun tearDownClass() {
        println("Clear data")
        testData = null
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