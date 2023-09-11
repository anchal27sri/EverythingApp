package com.example.everythingapp.calculator.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.everythingapp.calculator.ui.theme.EverythingAppTheme

@Composable
fun ExperimentScreen(
    myValueState: MutableState<Int>,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CalcSystem(myValueState = myValueState)
            Text(text = "Hello world bingo mad angles")
        }
    }
}

@Composable
fun CalcSystem(myValueState: MutableState<Int>) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(4.dp)
    ) {
        DecrementButton(
            doDecrement = { myValueState.value-- }
        )
        MiddleText(myValue = myValueState.value)
        IncrementButton(
            doIncrement = { myValueState.value++ }
        )
    }
}

@Composable
fun MiddleText(
    myValue: Int
) {
    Text(
        modifier = Modifier.padding(4.dp),
        text = myValue.toString(),
        fontSize = 24.sp
    )
}

@Composable
fun IncrementButton(
    doIncrement: () -> Unit
) {
    Button(
        modifier = Modifier.padding(4.dp),
        onClick = doIncrement
    ) {
        Image(
            imageVector = Icons.Default.Add,
            contentDescription = "Add icon"
        )
    }
}

@Composable
fun DecrementButton(
    doDecrement: () -> Unit
) {
    Button(
        modifier = Modifier.padding(4.dp),
        onClick = doDecrement
    ) {
        Text(text = "----")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EverythingAppTheme {
        val expressionState = remember {
            mutableStateOf("")
        }
        CalculatorScreen(expressionState)
    }
}