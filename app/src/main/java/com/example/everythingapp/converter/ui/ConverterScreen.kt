package com.example.everythingapp.converter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.everythingapp.converter.ui.screens.FirstHalfScreen
import com.example.everythingapp.converter.ui.theme.primaryBlackColor
import com.example.everythingapp.converter.ui.theme.secondaryGreenColor
import com.example.everythingapp.converter.util.IUnits
import com.example.everythingapp.converter.util.LengthUnits
import com.example.everythingapp.converter.util.UnitTypes
import com.example.everythingapp.converter.util.logics.CurrencyConversionLogic
import com.example.everythingapp.converter.util.logics.LengthConversionLogics
import com.example.everythingapp.converter.util.logics.TemperatureConversionLogic
import com.example.everythingapp.converter.util.logics.WeightConversionLogics

@Composable
fun ConverterScreen(
    modifier: Modifier = Modifier,
    unitType: UnitTypes,
) {
    val expressionState1 = remember { mutableStateOf("1") } // Magnitude
    val expressionState2 = remember { mutableStateOf("1") } // Magnitude
    val unitState1 = remember { mutableStateOf(unitType.getStandardUnit()) }
    val unitState2 = remember { mutableStateOf(unitType.getStandardUnit()) }
    val unitType1 = remember { mutableStateOf(unitType) }
    val unitType2 = remember { mutableStateOf(unitType) }
    val convertTheFirstHalf: (magnitude: Double, sourceUnit: IUnits) -> Unit = { mag, src ->
        expressionState1.value = when (unitType) {
            UnitTypes.LENGTH_UNITS -> LengthConversionLogics.convert(mag, src, unitState1.value).toString()
            UnitTypes.TEMPERATURE_UNITS -> TemperatureConversionLogic.convert(mag, src, unitState1.value).toString()
            UnitTypes.CURRENCY_UNITS -> CurrencyConversionLogic.convert(mag, src, unitState1.value).toString()
            UnitTypes.WEIGHT_UNITS -> WeightConversionLogics.convert(mag, src, unitState1.value).toString()
        }
    }
    val convertTheSecondHalf: (magnitude: Double, sourceUnit: IUnits) -> Unit = { mag, src ->
        expressionState2.value = when (unitType) {
            UnitTypes.LENGTH_UNITS -> LengthConversionLogics.convert(mag, src, unitState2.value).toString()
            UnitTypes.TEMPERATURE_UNITS -> TemperatureConversionLogic.convert(mag, src, unitState2.value).toString()
            UnitTypes.CURRENCY_UNITS -> CurrencyConversionLogic.convert(mag, src, unitState2.value).toString()
            UnitTypes.WEIGHT_UNITS -> WeightConversionLogics.convert(mag, src, unitState2.value).toString()
        }
    }
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        FirstHalfScreen(
            modifier = Modifier
                .background(color = primaryBlackColor)
                .weight(1f),
            expressionState = expressionState1,
            convertTheOtherOne = convertTheSecondHalf,
            unitNameState = unitState1,
            unitTypes = unitType1.value
        )
        FirstHalfScreen(
            modifier = Modifier
                .background(color = secondaryGreenColor)
                .weight(1f),
            expressionState = expressionState2,
            convertTheOtherOne = convertTheFirstHalf,
            unitNameState = unitState2,
            unitTypes = unitType2.value
        )
    }
}

@Preview
@Composable
fun ConverterScreenPreview(
) {
    ConverterScreen(modifier = Modifier, unitType = UnitTypes.LENGTH_UNITS)
}