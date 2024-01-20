package com.example.everythingapp.converter.util.logics

import com.example.everythingapp.converter.util.ConversionInterface
import com.example.everythingapp.converter.util.CurrencyUnits
import com.example.everythingapp.converter.util.IUnits
import com.example.everythingapp.converter.util.currencyConversionMap

object CurrencyConversionLogic: ConversionInterface {
    override fun convertToStandard(magnitude: Double, sourceUnit: IUnits): Double {
        return magnitude * currencyConversionMap["${sourceUnit.getName()}_to_${CurrencyUnits.usDollars}"]!!
    }

    override fun convertFromStandard(magnitude: Double, targetUnit: IUnits): Double {
        return magnitude / currencyConversionMap["${CurrencyUnits.usDollars}_to_${targetUnit.getName()}"]!!
    }
}