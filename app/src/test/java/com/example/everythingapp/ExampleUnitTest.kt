package com.example.everythingapp

import androidx.compose.runtime.mutableStateOf
import com.example.everythingapp.calculator.util.performButtonExecution
import com.example.everythingapp.calculator.util.validateExpression
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun performEvaluationByCalculator() {
        val expressionState = mutableStateOf("1----7")
        performButtonExecution(expressionState, "=")
        assertNotEquals(expressionState.value, "-6")
        assertEquals(validateExpression("1---8").isValid, true)
    }
}