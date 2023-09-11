package com.example.everythingapp.ui.calculatorComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.everythingapp.ui.buttons.BackspaceButton
import com.example.everythingapp.ui.buttons.GoScientificButton
import com.example.everythingapp.ui.theme.keypadBackgroundColor

@Composable
fun FunctionRow(
    modifier: Modifier = Modifier,
    expressionState: MutableState<String> = mutableStateOf(""),
) {
    Row(
        modifier = modifier.background(color = keypadBackgroundColor)
    ) {
        GoScientificButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            onButtonClick = {
                // TODO: Implement go scientific functionality
            }
        )
        BackspaceButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            onButtonClick = {
                expressionState.value = expressionState.value.dropLast(1)
            }
        )
    }
}

@Preview
@Composable
fun PreviewFunctionRow() {
    FunctionRow()
}