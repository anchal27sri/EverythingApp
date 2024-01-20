package com.example.everythingapp.converter.util.logics

import com.example.everythingapp.converter.util.ConversionInterface
import com.example.everythingapp.converter.util.CurrencyUnits
import com.example.everythingapp.converter.util.IUnits
import com.example.everythingapp.converter.util.MassUnits
import com.example.everythingapp.converter.util.isMetric
import com.example.everythingapp.converter.util.nonMetricMassConversionMap
import java.lang.Exception
import kotlin.math.pow

object WeightConversionLogics : ConversionInterface {
    override fun convertToStandard(
        magnitude: Double,
        sourceUnit: IUnits,
    ): Double {
        if (sourceUnit.getName() == CurrencyUnits.usDollars.name)
            return magnitude
        val mapString = "${sourceUnit}_to_${MassUnits.g}"
        return if (isMetric(sourceUnit.getOrdinal()))
            magnitude * 10.0.pow(sourceUnit.getOrdinal() - MassUnits.g.ordinal)
        else if (mapString in nonMetricMassConversionMap)
            magnitude * nonMetricMassConversionMap[mapString]!!
        else
            throw Exception()
    }

    override fun convertFromStandard(
        magnitude: Double,
        targetUnit: IUnits
    ): Double {
        if (targetUnit.getName() == CurrencyUnits.usDollars.name)
            return magnitude
        val mapString = "${MassUnits.g}_to_${targetUnit}"
        return if (isMetric(targetUnit.getOrdinal()))
            magnitude * 10.0.pow(MassUnits.g.ordinal - targetUnit.getOrdinal())
        else if (mapString in nonMetricMassConversionMap)
            magnitude * nonMetricMassConversionMap[mapString]!!
        else
            throw Exception()
    }
}