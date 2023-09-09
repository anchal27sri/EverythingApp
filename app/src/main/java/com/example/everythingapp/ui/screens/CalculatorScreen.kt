package com.example.everythingapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.everythingapp.ui.calculatorComponents.CalculatorKeyPad
import com.example.everythingapp.ui.calculatorComponents.EditorComponent

@Preview
@Composable
fun CalculatorScreen(
    expressionState: MutableState<String> = mutableStateOf("Edit Text")
) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        EditorComponent(
            modifier = Modifier.weight(1f),
            expressionState = expressionState
        )
        CalculatorKeyPad(
            modifier = Modifier,
            expressionState = expressionState
        )
    }
}