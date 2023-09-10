package com.example.everythingapp.util

import android.util.Log
import androidx.compose.runtime.MutableState
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.ValidationResult

fun performButtonExecution(
    expressionState: MutableState<String>,
    buttonText: String): List<String> {
    when(buttonTextToTypeMap[buttonText]!!) {
        ButtonTypes.CLEAR -> {
            expressionState.value = ""
        }
        ButtonTypes.BRACES -> {
            expressionState.value += buttonText
        }
        ButtonTypes.OPERATOR, ButtonTypes.OPERAND -> {
            expressionState.value += buttonText
        }
        ButtonTypes.INVERT -> {
            expressionState.value += "-${expressionState.value}"
        }
        ButtonTypes.EVALUATE -> {
            if (expressionState.value.isEmpty())
                return listOf("Error: Empty input")
            val validationResult = validateExpression(expressionState.value)
            if (validationResult.isValid) {
                Log.d("debug", expressionState.value)
                val expression = ExpressionBuilder(expressionState.value).build()
                val result = expression.evaluate()
                val resultToBeShown = if (result.toInt().toDouble() == result)
                                            result.toInt().toString()
                                        else
                                            result.toString()
                expressionState.value = resultToBeShown
            } else {
                return validationResult.errors
            }
        }
    }
    return emptyList()
}

fun validateExpression(text: String): ValidationResult {
    val expression = ExpressionBuilder(text).build()
    return expression.validate(true)
}