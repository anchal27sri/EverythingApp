package com.example.everythingapp.calculator.ui.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.everythingapp.R
import com.example.everythingapp.calculator.ui.theme.buttonBackgroundBlack
import com.example.everythingapp.calculator.ui.theme.buttonBorderColor
import com.example.everythingapp.calculator.ui.theme.buttonTextColor

@Composable
fun GoScientificButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {},
    textColor: Color = buttonTextColor,
    backgroundColor: Color = buttonBackgroundBlack,
) {
    OutlinedButton(
        modifier = modifier.height(48.dp),
        onClick = onButtonClick,
        border = BorderStroke(0.25.dp, buttonBorderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor
        ),
        shape = RectangleShape,
    ) {
        Text(
            text = stringResource(id = R.string.go_scientific),
            color = textColor
        )
    }
}

@Preview
@Composable
fun PreviewGoScientificButton() {
    GoScientificButton(
        modifier = Modifier.fillMaxWidth(),
    )
}