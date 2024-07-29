package com.example.everythingapp.converter.ui.screens

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
import com.example.everythingapp.converter.ui.theme.secondaryGreenColor
import com.example.everythingapp.converter.util.IUnits
import com.example.everythingapp.converter.util.LengthUnits
import com.example.everythingapp.converter.util.UnitTypes

@Composable
fun FirstHalfScreen(
    modifier: Modifier = Modifier,
    expressionState: MutableState<String> = mutableStateOf("1"),
    convertTheOtherOne: (magnitude: Double, sourceUnit: IUnits) -> Unit,
    unitNameState: MutableState<IUnits> = mutableStateOf(LengthUnits.m),
    unitTypes: UnitTypes
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var expanded by remember { mutableStateOf(false) }
        // hello world
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
                    text = unitNameState.value.getName(),
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
                for (unit in unitTypes.getUnitValues() as Array<IUnits>) {
                    DropdownMenuItem(
                        text = { Text(text = unit.getName()) },
                        onClick = {
                            unitNameState.value = unit
                            expanded = false
                            if (isConvertibleToDouble(expressionState.value)) {
                                convertTheOtherOne(expressionState.value.toDouble(), unit)
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
        modifier = Modifier.background(color = secondaryGreenColor),
        convertTheOtherOne = {_, _, ->  },
        unitTypes = UnitTypes.LENGTH_UNITS,
    )
}

fun isConvertibleToDouble(input: String): Boolean {
    return input.toDoubleOrNull() != null
}
