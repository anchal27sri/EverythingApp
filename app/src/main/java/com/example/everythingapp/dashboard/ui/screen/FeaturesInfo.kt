package com.example.everythingapp.dashboard.ui.screen

import com.example.everythingapp.R
import com.example.everythingapp.ScreenEnums

data class FeaturesData(
    val screenEnum: ScreenEnums,
    val resourceId: Int,
)

val featureList: List<FeaturesData> = listOf(
    FeaturesData(ScreenEnums.CALCULATOR, R.drawable.ic_calculator_image_for_dashboard),
    FeaturesData(ScreenEnums.CONVERTER, R.drawable.ic_converter_icon_for_dashboard),
)