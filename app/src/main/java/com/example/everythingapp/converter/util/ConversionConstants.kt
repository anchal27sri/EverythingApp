package com.example.everythingapp.converter.util

val nonMetricLengthConversionMap = mapOf(
    "${LengthUnits.m.name}_to_${LengthUnits.miles.name}" to 0.00062137119,
    "${LengthUnits.miles.name}_to_${LengthUnits.m.name}" to 1609.34,
)

val nonMetricMassConversionMap = mapOf(
    "${MassUnits.kg.name}_to_${MassUnits.quintal.name}" to 0.01,
    "${MassUnits.quintal.name}_to_${MassUnits.kg.name}" to 100.0,
    "${MassUnits.kg.name}_to_${MassUnits.tone.name}" to 0.001,
    "${MassUnits.tone.name}_to_${MassUnits.kg.name}" to 1000.0,
)

val currencyConversionMap = mapOf(
    "${CurrencyUnits.poundSterling.name}_to_${CurrencyUnits.usDollars.name}" to 1.27,
    "${CurrencyUnits.euro.name}_to_${CurrencyUnits.usDollars.name}" to 1.11,
    "${CurrencyUnits.japaneseYen.name}_to_${CurrencyUnits.usDollars.name}" to 0.0071,
    "${CurrencyUnits.indianRupee.name}_to_${CurrencyUnits.usDollars.name}" to 0.012,
    "${CurrencyUnits.chineseYuan.name}_to_${CurrencyUnits.usDollars.name}" to 0.14,
    "${CurrencyUnits.canadianDollars.name}_to_${CurrencyUnits.usDollars.name}" to 0.76,
    "${CurrencyUnits.uaeDirham.name}_to_${CurrencyUnits.usDollars.name}" to 0.27,
)