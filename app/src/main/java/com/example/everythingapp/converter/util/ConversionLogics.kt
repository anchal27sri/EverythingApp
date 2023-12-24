package com.example.everythingapp.converter.util

fun lengthConvert(
    magnitude: Double,
    sourceUnit: LengthUnits,
    targetUnit: LengthUnits
): Double {
    if (sourceUnit == targetUnit)
        return magnitude
    val magnitudeInMeters = changeToMeter(magnitude = magnitude, sourceUnit = sourceUnit)
    return changeFromMeter(magnitudeInMeters, targetUnit)
}


