package com.example.everythingapp.calculator.ui

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.everythingapp.calculator.ui.screens.CalculatorScreen

@Composable
fun EverythingApp() {
    val navController = rememberNavController()
    EverythingApp(navController = navController)
}

@Composable
fun EverythingApp(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            CalculatorScreen()
        }
    }
}