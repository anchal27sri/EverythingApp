package com.example.everythingapp.converter.ui.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UnitText(
    text: String,
) {
    Text(text = text)
}

@Preview
@Composable
fun UnitText() {
    UnitText(text = "Cm")
}