package com.example.everythingapp.calculator.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.everythingapp.calculator.ui.theme.EverythingAppTheme

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EverythingAppTheme {
        val expressionState = remember {
            mutableStateOf("")
        }
        CalculatorScreen(expressionState)
    }
}