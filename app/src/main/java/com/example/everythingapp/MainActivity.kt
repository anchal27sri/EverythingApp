package com.example.everythingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.everythingapp.calculator.ui.EverythingApp
import com.example.everythingapp.converter.util.LengthUnits

class MainActivity : ComponentActivity() {

    private val expressionState1: MutableState<String> = mutableStateOf("1")
    private val expressionState2: MutableState<String> = mutableStateOf("1")
    private val unitNameState1: MutableState<LengthUnits> = mutableStateOf(LengthUnits.m)
    private val unitNameState2: MutableState<LengthUnits> = mutableStateOf(LengthUnits.m)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EverythingApp(
                expressionState1 = expressionState1,
                expressionState2 = expressionState2,
                unitNameState1 = unitNameState1,
                unitNameState2 = unitNameState2,
            )
        }
    }
}