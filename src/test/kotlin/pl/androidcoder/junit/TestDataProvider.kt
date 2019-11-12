package pl.androidcoder.junit

class TestDataProvider {
    fun getData(): List<TestData> {
        println("Start loading test data...")
        Thread.sleep(4000)
        println("Test data loaded")
        return listOf(
                TestData(100, 123),
                TestData(100, 123)

        )
    }
}

data class TestData(val input: Int, val output: Int)