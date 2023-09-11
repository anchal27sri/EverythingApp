package com.example.everythingapp.calculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.everythingapp.calculator.ui.calculatorComponents.CalculatorKeyPad
import com.example.everythingapp.calculator.ui.calculatorComponents.EditorComponent
import com.example.everythingapp.calculator.ui.calculatorComponents.FunctionRow

@Preview
@Composable
fun CalculatorScreen(
    expressionState: MutableState<String> = mutableStateOf("")
) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        EditorComponent(
            modifier = Modifier.weight(1f),
            expressionState = expressionState
        )
        FunctionRow(
            modifier = Modifier.fillMaxWidth(),
            expressionState = expressionState
        )
        CalculatorKeyPad(
            modifier = Modifier,
            expressionState = expressionState
        )
    }
}