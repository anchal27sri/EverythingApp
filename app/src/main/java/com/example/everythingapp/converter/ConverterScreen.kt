package com.example.everythingapp.converter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.everythingapp.converter.ui.halfScreens.FirstHalfScreen
import com.example.everythingapp.converter.ui.theme.firstHalfBackgroundColor
import com.example.everythingapp.converter.ui.theme.secondHalBackgroundColor
import com.example.everythingapp.converter.util.LengthUnits
import com.example.everythingapp.converter.util.lengthConvert

@Composable
fun ConverterScreen(
    modifier: Modifier = Modifier,
    expressionState1: MutableState<String>,
    expressionState2: MutableState<String>,
    unitNameState1: MutableState<LengthUnits>,
    unitNameState2: MutableState<LengthUnits>,
) {
    val convertTheFirstHalf: (magnitude: Double, sourceUnit: LengthUnits) -> Unit = { mag, src ->
        expressionState1.value = lengthConvert(mag, src, unitNameState1.value).toString()
    }
    val convertTheSecondHalf: (magnitude: Double, sourceUnit: LengthUnits) -> Unit = { mag, src ->
        expressionState2.value = lengthConvert(mag, src, unitNameState2.value).toString()
    }
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        FirstHalfScreen(
            modifier = Modifier
                .background(color = firstHalfBackgroundColor)
                .weight(1f),
            expressionState = expressionState1,
            convertTheSecondHalf,
            unitNameState1,
        )
        FirstHalfScreen(
            modifier = Modifier
                .background(color = secondHalBackgroundColor)
                .weight(1f),
            expressionState = expressionState2,
            convertTheFirstHalf,
            unitNameState2
        )
    }
}

@Preview
@Composable
fun ConverterScreenPreview(
    modifier: Modifier = Modifier,
    expressionState1: MutableState<String> = mutableStateOf("1"),
    expressionState2: MutableState<String> = mutableStateOf("1"),
    unitNameState1: MutableState<LengthUnits> = mutableStateOf(LengthUnits.m),
    unitNameState2: MutableState<LengthUnits> = mutableStateOf(LengthUnits.m)
) {
    ConverterScreen(
        modifier = modifier,
        expressionState1 = expressionState1,
        expressionState2 = expressionState2,
        unitNameState1 = unitNameState1,
        unitNameState2 = unitNameState2
    )
}