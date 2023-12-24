package com.example.everythingapp.converter.ui.halfScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.everythingapp.converter.ui.texts.FirstHalfEditableText
import com.example.everythingapp.converter.ui.theme.secondHalBackgroundColor
import com.example.everythingapp.converter.util.LengthUnits

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstHalfScreen(
    modifier: Modifier = Modifier,
    expressionState: MutableState<String> = mutableStateOf("1"),
    convertTheOtherOne: (magnitude: Double, sourceUnit: LengthUnits) -> Unit,
    unitNameState: MutableState<LengthUnits> = mutableStateOf(LengthUnits.m)
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var expanded by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .border(width = 2.dp, color = Color.White)
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
                .clickable { expanded = true }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = unitNameState.value.name,
                    modifier = Modifier
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down arrow",
                    tint = Color.White
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                for (units in LengthUnits.values()) {
                    DropdownMenuItem(
                        text = { Text(text = units.name) },
                        onClick = {
                            unitNameState.value = units
                            expanded = false
                            if (isConvertibleToDouble(expressionState.value)) {
                                convertTheOtherOne(expressionState.value.toDouble(), units)
                            }
                        }
                    )
                }
            }
        }

        FirstHalfEditableText(
            expressionState = expressionState,
            convertTheOtherOne = convertTheOtherOne,
            unitNameState = unitNameState
        )
    }
}

@Preview
@Composable
fun FirstHalfScreenPreview() {
    FirstHalfScreen(
        modifier = Modifier.background(color = secondHalBackgroundColor),
        convertTheOtherOne = {_, _, ->  },
    )
}

fun isConvertibleToDouble(input: String): Boolean {
    return input.toDoubleOrNull() != null
}
