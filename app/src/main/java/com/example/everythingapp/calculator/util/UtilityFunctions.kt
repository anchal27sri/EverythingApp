package com.example.everythingapp.calculator.util

import androidx.compose.runtime.MutableState
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.ValidationResult

fun performButtonExecution(
    expressionState: MutableState<String>,
    buttonText: String
): List<String> {
    when(buttonTextToTypeMap[buttonText]!!) {
        ButtonTypes.CLEAR -> {
            expressionState.value = ""
        }
        ButtonTypes.BRACES -> {
            if (expressionState.value.isEmpty()) {
                expressionState.value += "("
            } else {
                val lastCharacter = expressionState.value[expressionState.value.length - 1]
                if (buttonTextToTypeMap[lastCharacter.toString()] == ButtonTypes.OPERAND)
                    expressionState.value += ")"
                else if (buttonTextToTypeMap[lastCharacter.toString()] == ButtonTypes.OPERATOR)
                    expressionState.value += "("
                else
                    return listOf("Error: Wrong Input")
            }
        }
        ButtonTypes.OPERATOR, ButtonTypes.OPERAND -> {
            expressionState.value += buttonText
        }
        ButtonTypes.INVERT -> {
            expressionState.value = "-${expressionState.value}"
        }
        ButtonTypes.EVALUATE -> {
            if (expressionState.value.isEmpty())
                return listOf("Error: Empty input")
            val validationResult = validateExpression(expressionState.value)
            if (validationResult.isValid) {
                // Log.d("debug", expressionState.value)
                try {
                    val expression = ExpressionBuilder(expressionState.value).build()
                    val result = expression.evaluate()
                    val resultToBeShown = if (result.toInt().toDouble() == result)
                        result.toInt().toString()
                    else
                        result.toString()
                    if (resultToBeShown != "infinity")
                        expressionState.value = resultToBeShown
                    else
                        return listOf("Error: Result exceeded calculator limit")
                } catch (e: Exception) {
                    return listOf(e.toString().substringAfter(':'))
                }
             } else {
                return validationResult.errors
            }
        }
    }
    return emptyList()
}

fun validateExpression(text: String): ValidationResult {
    val validationResult = try {
        val expression = ExpressionBuilder(text).build()
        expression.validate(true)
    } catch (e: Exception) {
        ValidationResult(false, listOf("Error: Wrong Input"))
    }
    return validationResult
}