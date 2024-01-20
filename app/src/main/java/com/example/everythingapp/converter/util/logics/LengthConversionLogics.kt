package com.example.everythingapp.converter.util.logics

import com.example.everythingapp.converter.util.ConversionInterface
import com.example.everythingapp.converter.util.CurrencyUnits
import com.example.everythingapp.converter.util.LengthUnits
import com.example.everythingapp.converter.util.IUnits
import com.example.everythingapp.converter.util.isMetric
import com.example.everythingapp.converter.util.nonMetricLengthConversionMap
import java.lang.Exception
import kotlin.math.pow

object LengthConversionLogics : ConversionInterface {

    override fun convertToStandard(
        magnitude: Double,
        sourceUnit: IUnits,
    ): Double {
        if (sourceUnit.getName() == LengthUnits.m.name)
            return magnitude
        val mapString = "${sourceUnit}_to_${LengthUnits.m}"
        return if (isMetric(sourceUnit.getOrdinal()))
            magnitude * 10.0.pow(sourceUnit.getOrdinal() - LengthUnits.m.ordinal)
        else if (mapString in nonMetricLengthConversionMap)
            magnitude * nonMetricLengthConversionMap[mapString]!!
        else
            throw Exception()
    }

    override fun convertFromStandard(
        magnitude: Double,
        targetUnit: IUnits
    ): Double {
        if (targetUnit.getName() == LengthUnits.m.name)
            return magnitude
        val mapString = "${LengthUnits.m}_to_${targetUnit}"
        return if (isMetric(targetUnit.getOrdinal()))
            magnitude * 10.0.pow(LengthUnits.m.ordinal - targetUnit.getOrdinal())
        else if (mapString in nonMetricLengthConversionMap)
            magnitude * nonMetricLengthConversionMap[mapString]!!
        else
            throw Exception()
    }
}

