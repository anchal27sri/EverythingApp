package com.example.everythingapp

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.everythingapp.calculator.ui.screens.CalculatorScreen
import com.example.everythingapp.converter.ui.screens.ConversionSelectionScreen
import com.example.everythingapp.dashboard.ui.screen.DashboardScreen

@Composable
fun EverythingApp(
    navigationState: MutableState<ScreenEnums>,
) {
    val navController = rememberNavController()
    EverythingApp(
        navigationState = navigationState,
        navController = navController,
    )
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun EverythingApp(
    navController: NavHostController,
    navigationState: MutableState<ScreenEnums>,
) {
    val expressionState: MutableState<String> = mutableStateOf("1")
    NavHost(navController = navController, startDestination = navigationState.value.name) {
        composable(ScreenEnums.DASHBOARD.name) {
            DashboardScreen(navigationState = navigationState)
        }
        composable(ScreenEnums.CALCULATOR.name) {
            CalculatorScreen(
                expressionState = expressionState
            )
        }
        composable(ScreenEnums.CONVERTER.name) {
            ConversionSelectionScreen()
        }
    }
}