package com.example.everythingapp.calculator.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.everythingapp.converter.ConverterScreen
import com.example.everythingapp.converter.util.LengthUnits

@Composable
fun EverythingApp(
    expressionState1: MutableState<String>,
    expressionState2: MutableState<String>,
    unitNameState1: MutableState<LengthUnits>,
    unitNameState2: MutableState<LengthUnits>,
) {
    val navController = rememberNavController()
    EverythingApp(
        navController = navController,
        expressionState1 = expressionState1,
        expressionState2 = expressionState2,
        unitNameState1 = unitNameState1,
        unitNameState2 = unitNameState2,
    )
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun EverythingApp(
    navController: NavHostController,
    expressionState1: MutableState<String>,
    expressionState2: MutableState<String>,
    unitNameState1: MutableState<LengthUnits>,
    unitNameState2: MutableState<LengthUnits>
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            ConverterScreen(
                expressionState1 = expressionState1,
                expressionState2 = expressionState2,
                unitNameState1 = unitNameState1,
                unitNameState2 = unitNameState2,
            )
        }
    }
}