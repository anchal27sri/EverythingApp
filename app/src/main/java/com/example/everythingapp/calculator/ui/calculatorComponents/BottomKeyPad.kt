package com.example.everythingapp.calculator.ui.calculatorComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.everythingapp.calculator.ui.buttons.CalculatorButton
import com.example.everythingapp.calculator.ui.theme.buttonTextColorSoftBlue
import com.example.everythingapp.calculator.ui.theme.buttonTextColorSoftRed
import com.example.everythingapp.calculator.ui.theme.keypadBackgroundColor

@Preview
@Composable
fun CalculatorKeyPad(
    modifier: Modifier = Modifier,
    expressionState: MutableState<String> = mutableStateOf("")
) {
    Column(
        modifier = modifier.background(color = keypadBackgroundColor),
    ) {
        Row {
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "C",
                textColor = buttonTextColorSoftRed,
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "()",
                textColor = buttonTextColorSoftBlue,
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "%",
                textColor = buttonTextColorSoftBlue,
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "/",
                textColor = buttonTextColorSoftBlue,
                expressionState = expressionState
            )
        }
        Row {
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "7",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "8",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "9",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "*",
                textColor = buttonTextColorSoftBlue,
                expressionState = expressionState
            )
        }
        Row {
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "4",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "5",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "6",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "-",
                textColor = buttonTextColorSoftBlue,
                expressionState = expressionState
            )
        }
        Row {
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "3",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "2",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "1",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "+",
                textColor = buttonTextColorSoftBlue,
                expressionState = expressionState
            )
        }
        Row {
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "+/-",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "0",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = ".",
                expressionState = expressionState
            )
            CalculatorButton(
                modifier = Modifier.weight(1f),
                buttonText = "=",
                textColor = buttonTextColorSoftBlue,
                expressionState = expressionState
            )
        }
    }
}