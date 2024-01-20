package com.example.everythingapp.dashboard.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.everythingapp.R
import com.example.everythingapp.converter.ui.theme.primaryBlackColor
import com.example.everythingapp.converter.ui.theme.secondaryGreenColor

@Composable
fun UtilityCard(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier
            .border(2.dp, secondaryGreenColor, RoundedCornerShape(8.dp))
            .padding(6.dp)
            .background(primaryBlackColor)
            .padding(2.dp),
        text = text,
        fontSize = 36.sp,
        color = secondaryGreenColor,
        fontWeight = FontWeight.Bold
    )
}


@Preview
@Composable
fun CalculatorCardPreview() {
    UtilityCard(
        text = "Calculator"
    )
}

@Preview
@Composable
fun ConverterCardPreview() {
    UtilityCard(
        text = "Converter"
    )
}