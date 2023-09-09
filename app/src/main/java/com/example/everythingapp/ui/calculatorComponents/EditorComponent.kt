package com.example.everythingapp.ui.calculatorComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun EditorComponent(
    modifier: Modifier,
    text: String
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 32.sp
        )
    }
}

@Composable
fun EditorComponent(
    modifier: Modifier,
    expressionState: MutableState<String> = mutableStateOf("")
) {
    EditorComponent(
        modifier,
        expressionState.value
    )
}

@Preview
@Composable
fun PreviewEditorComponent() {
    EditorComponent(
        modifier = Modifier,
        text = "1 + 3"
    )
}