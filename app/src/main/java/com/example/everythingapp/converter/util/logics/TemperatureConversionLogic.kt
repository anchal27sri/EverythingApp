package com.example.everythingapp.converter.util.logics

import com.example.everythingapp.converter.util.ConversionInterface
import com.example.everythingapp.converter.util.CurrencyUnits
import com.example.everythingapp.converter.util.IUnits
import com.example.everythingapp.converter.util.TemparatureUnits

object TemperatureConversionLogic : ConversionInterface {

    override fun convertToStandard(
        magnitude: Double,
        sourceUnit: IUnits
    ): Double {
        if (sourceUnit.getName() == TemparatureUnits.celcius.name)
            return magnitude
        return if (sourceUnit == TemparatureUnits.kelvin)
            magnitude - 273.15
        else
            5.0 * (magnitude - 32.0) / 9.0
    }

    override fun convertFromStandard(
        magnitude: Double,
        targetUnit: IUnits
    ): Double {
        if (targetUnit.getName() == CurrencyUnits.usDollars.name)
            return magnitude
        return if (targetUnit == TemparatureUnits.kelvin)
            magnitude + 273.15
        else
            (9.0 * magnitude) / 5.0 + 32.0
    }
}