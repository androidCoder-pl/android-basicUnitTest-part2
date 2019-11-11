package pl.androidcoder.junit

import org.junit.After
import org.junit.Before
import org.junit.Test

class Independent{

    private var variable = 0

    @Before
    fun setUp1() {
        println("----@Before1----")
        variable = -1
    }

    @After
    fun tearDown() {
        println("@After variable : $variable")
    }

    @Test
    fun test1(){
        println("test1 variable : $variable")
        println("test1 object hash: ${hashCode()}")
        variable = 1
    }

    @Test
    fun test2(){
        println("test2 variable : $variable")
        println("test2 object hash: ${hashCode()}")
        variable = 2
    }
}