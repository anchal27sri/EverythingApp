package com.example.everythingapp.converter.util.logics

import com.example.everythingapp.converter.util.ConversionInterface
import com.example.everythingapp.converter.util.CurrencyUnits
import com.example.everythingapp.converter.util.IUnits
import com.example.everythingapp.converter.util.currencyConversionMap

object CurrencyConversionLogic: ConversionInterface {
    override fun convertToStandard(magnitude: Double, sourceUnit: IUnits): Double {
        if (sourceUnit.getName() == CurrencyUnits.usDollars.name)
            return magnitude
        return magnitude * currencyConversionMap["${sourceUnit.getName()}_to_${CurrencyUnits.usDollars.name}"]!!
    }

    override fun convertFromStandard(magnitude: Double, targetUnit: IUnits): Double {
        if (targetUnit.getName() == CurrencyUnits.usDollars.name)
            return magnitude
        return magnitude / currencyConversionMap["${targetUnit.getName()}_to_${CurrencyUnits.usDollars.name}"]!!
    }
}