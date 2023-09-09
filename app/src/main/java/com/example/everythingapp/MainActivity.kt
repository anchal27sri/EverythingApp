package com.example.everythingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.everythingapp.ui.screens.CalculatorScreen
import com.example.everythingapp.ui.theme.EverythingAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var expressionState: MutableState<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            expressionState = remember {
                mutableStateOf("")
            }
            EverythingAppTheme {
                CalculatorScreen(expressionState = expressionState)
            }
        }
    }
}