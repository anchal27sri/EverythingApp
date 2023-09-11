package com.example.everythingapp.calculator.ui.buttons

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.everythingapp.R
import com.example.everythingapp.calculator.ui.theme.buttonBackgroundBlack
import com.example.everythingapp.calculator.ui.theme.buttonBorderColor
import com.example.everythingapp.calculator.ui.theme.buttonTextColor
import com.example.everythingapp.calculator.util.performButtonExecution

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    textColor: Color = buttonTextColor,
    backgroundColor: Color = buttonBackgroundBlack,
    onClickButton: () -> Unit = {},
) {
    OutlinedButton(
        modifier = modifier.height(96.dp),
        border = BorderStroke(0.25.dp, buttonBorderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor
        ),
        shape = RectangleShape,
        onClick = onClickButton,
    ) {
        Text(
            color = textColor,
            text = buttonText,
            fontSize = 32.sp,
        )
    }
}

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    buttonText: String = "2",
    toastError: String = stringResource(id = R.string.toast_error),
    textColor: Color = buttonTextColor,
    backgroundColor: Color = buttonBackgroundBlack,
    expressionState: MutableState<String> = mutableStateOf(""),
    localContext: Context = LocalContext.current
) {
    CalculatorButton(
        modifier = modifier,
        buttonText = buttonText,
        textColor = textColor,
        backgroundColor = backgroundColor,
        onClickButton = {
            val errorList = performButtonExecution(expressionState, buttonText)
            if (errorList.isNotEmpty()) {
                Toast.makeText(localContext, "$toastError ${errorList[0]}", Toast.LENGTH_SHORT).show()
            }
        },
    )
}

@Preview
@Composable
fun PreviewCalculatorButton() {
    CalculatorButton(
        modifier = Modifier.fillMaxWidth(),
        buttonText = "-",
        onClickButton = { },
    )
}