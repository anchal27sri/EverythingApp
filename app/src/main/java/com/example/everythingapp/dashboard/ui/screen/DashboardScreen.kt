package com.example.everythingapp.dashboard.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.everythingapp.ScreenEnums
import com.example.everythingapp.converter.ui.theme.primaryBlackColor

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navigationState: MutableState<ScreenEnums>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = primaryBlackColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose a utility:",
            fontSize = 24.sp,
            color = Color.White
        )
        for (it in featureList) {
            UtilityCard(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .clickable { navigationState.value = it.screenEnum },
                text = it.screenEnum.name
            )
        }
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    val navigationState: MutableState<ScreenEnums> = remember { mutableStateOf(ScreenEnums.DASHBOARD) }
    DashboardScreen(navigationState = navigationState)
}