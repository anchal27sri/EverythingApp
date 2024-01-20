package com.example.everythingapp.converter.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.everythingapp.ScreenEnums
import com.example.everythingapp.converter.ui.ConverterScreen
import com.example.everythingapp.converter.ui.theme.primaryBlackColor
import com.example.everythingapp.converter.ui.theme.secondaryGreenColor
import com.example.everythingapp.converter.util.ConverterScreens
import com.example.everythingapp.converter.util.UnitTypes

@Composable
fun ConversionSelectionScreen(
    modifier: Modifier = Modifier,
) {
    val navigationState = remember { mutableStateOf(ConverterScreens.SELECTION_SCREEN) }
    val conversionUnit = remember { mutableStateOf(UnitTypes.LENGTH_UNITS) }
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = navigationState.value.name) {
        composable(ConverterScreens.SELECTION_SCREEN.name) {
            ConversionSelectionScreen(
                modifier = modifier,
                navigationState = navigationState,
                conversionUnit = conversionUnit,
            )
        }
        composable(ConverterScreens.CONVERTER_SCREEN.name) {
            ConverterScreen(
                modifier = modifier,
                unitType = conversionUnit.value
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversionSelectionScreen(
    modifier: Modifier = Modifier,
    navigationState: MutableState<ConverterScreens> = mutableStateOf(ConverterScreens.SELECTION_SCREEN),
    conversionUnit: MutableState<UnitTypes>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = primaryBlackColor),
        verticalArrangement = Arrangement.Center,
    ) {
        for (item in UnitTypes.values()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    navigationState.value = ConverterScreens.CONVERTER_SCREEN
                    conversionUnit.value = item
                }
            ) {
                Text(
                    modifier = Modifier
                        .border(4.dp, color = Color.White)
                        .fillMaxWidth()
                        .background(color = secondaryGreenColor)
                        .padding(24.dp),
                    text = item.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
fun ConversionSelectionScreenPreview() {
    ConversionSelectionScreen()
}
