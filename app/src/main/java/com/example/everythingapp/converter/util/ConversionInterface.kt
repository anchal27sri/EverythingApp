package com.example.everythingapp.converter.util

interface ConversionInterface {

    fun convert(magnitude: Double, source: IUnits, target: IUnits): Double {
        if (source == target) {
            return magnitude
        }
        return convertFromStandard(convertToStandard(magnitude, source), target)
    }
    fun convertToStandard(magnitude: Double, sourceUnit: IUnits): Double
    fun convertFromStandard(magnitude: Double, targetUnit: IUnits): Double
}