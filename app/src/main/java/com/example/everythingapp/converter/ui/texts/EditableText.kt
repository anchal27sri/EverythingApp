package com.example.everythingapp.converter.ui.texts

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.everythingapp.converter.ui.screens.isConvertibleToDouble
import com.example.everythingapp.converter.util.IUnits

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstHalfEditableText(
    expressionState: MutableState<String>,
    convertTheOtherOne: (arg: Double, src: IUnits) -> Unit,
    unitNameState: MutableState<IUnits>
) {
    TextField(
        modifier = Modifier
            .padding(start = 48.dp, end = 48.dp),
        value = expressionState.value,
        onValueChange = {
            Log.d("Anchal", "being typed: $it")
            if (isConvertibleToDouble(it)) {
                expressionState.value = it
                convertTheOtherOne(it.toDouble(), unitNameState.value)
            }
        },
        textStyle = TextStyle(
            fontSize = 48.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            containerColor = Color.Transparent
        ),
    )
}