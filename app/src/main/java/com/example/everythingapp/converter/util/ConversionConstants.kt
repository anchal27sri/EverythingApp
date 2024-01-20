package com.example.everythingapp.converter.util

val nonMetricLengthConversionMap = mapOf(
    "${LengthUnits.m}_to_${LengthUnits.miles}" to 0.00062137119,
    "${LengthUnits.miles}_to_${LengthUnits.m}" to 1609.34,
)

val nonMetricMassConversionMap = mapOf(
    "${MassUnits.kg}_to_${MassUnits.quintal}" to 0.01,
    "${MassUnits.quintal}_to_${MassUnits.kg}" to 100.0,
    "${MassUnits.kg}_to_${MassUnits.tone}" to 0.001,
    "${MassUnits.tone}_to_${MassUnits.kg}" to 1000.0,
)

val currencyConversionMap = mapOf(
    "${CurrencyUnits.poundSterling}_to_${CurrencyUnits.usDollars}" to 1.27,
    "${CurrencyUnits.euro}_to_${CurrencyUnits.usDollars}" to 1.11,
    "${CurrencyUnits.japaneseYen}_to_${CurrencyUnits.usDollars}" to 0.0071,
    "${CurrencyUnits.indianRupee}_to_${CurrencyUnits.usDollars}" to 0.012,
    "${CurrencyUnits.chineseYuan}_to_${CurrencyUnits.usDollars}" to 0.14,
    "${CurrencyUnits.canadianDollars}_to_${CurrencyUnits.usDollars}" to 0.76,
    "${CurrencyUnits.uaeDirham}_to_${CurrencyUnits.usDollars}" to 0.27,
)