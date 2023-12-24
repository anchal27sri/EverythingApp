package com.example.everythingapp.converter.util

import java.lang.Exception
import kotlin.math.pow

val metricConversionMap = mutableMapOf(
    LengthUnits.mm to 0,
    LengthUnits.cm to 1,
    LengthUnits.dm to 2,
    LengthUnits.m to 3,
    LengthUnits.dam to 4,
    LengthUnits.hm to 5,
    LengthUnits.km to 6,
)

val nonMetricConversionMap = mutableMapOf(
    "${LengthUnits.m}_to_${LengthUnits.miles}" to 0.00062137119,
    "${LengthUnits.miles}_to_${LengthUnits.m}" to 1609.34,
)

fun changeToMeter(
    magnitude: Double,
    sourceUnit: LengthUnits,
): Double {
    val mapString = "${sourceUnit}_to_${LengthUnits.m}"
    return if (sourceUnit in metricConversionMap)
        magnitude * 10.0.pow(metricConversionMap[sourceUnit]!! - metricConversionMap[LengthUnits.m]!!)
    else if (mapString in nonMetricConversionMap)
        magnitude * nonMetricConversionMap[mapString]!!
    else
        throw Exception()
}

fun changeFromMeter(
    magnitude: Double,
    targetUnit: LengthUnits
): Double {
    val mapString = "${LengthUnits.m}_to_${targetUnit}"
    return if (targetUnit in metricConversionMap)
        magnitude * 10.0.pow(metricConversionMap[LengthUnits.m]!! - metricConversionMap[targetUnit]!!)
    else if (mapString in nonMetricConversionMap)
        magnitude * nonMetricConversionMap[mapString]!!
    else
        throw Exception()
}