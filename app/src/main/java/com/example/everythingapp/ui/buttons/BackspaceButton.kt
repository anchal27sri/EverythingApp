package com.example.everythingapp.ui.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.everythingapp.R
import com.example.everythingapp.ui.theme.buttonBackgroundBlack
import com.example.everythingapp.ui.theme.buttonBackspaceInternalColor
import com.example.everythingapp.ui.theme.buttonBorderColor

@Composable
fun BackspaceButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {},
    imageColor: Color = buttonBackspaceInternalColor,
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
        Image(
            painter = painterResource(id = R.drawable.ic_backspace_svg),
            contentDescription = "back button",
            colorFilter = ColorFilter.tint(imageColor)
        )
    }
}

@Preview
@Composable
fun PreviewBackspaceButton() {
    BackspaceButton(
        modifier = Modifier.fillMaxWidth(),
    )
}