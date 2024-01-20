package com.example.everythingapp.converter.util

import java.util.Objects

enum class ConverterScreens {
    SELECTION_SCREEN,
    CONVERTER_SCREEN,
}

enum class UnitTypes {
    LENGTH_UNITS,
    WEIGHT_UNITS,
    CURRENCY_UNITS,
    TEMPERATURE_UNITS;

    fun getStandardUnit(): IUnits {
        return when(this) {
            LENGTH_UNITS -> LengthUnits.m
            WEIGHT_UNITS -> MassUnits.g
            CURRENCY_UNITS -> CurrencyUnits.usDollars
            TEMPERATURE_UNITS -> TemparatureUnits.kelvin
        }
    }

    fun getUnitValues(): Any {
        return when (this) {
            LENGTH_UNITS -> LengthUnits.values()
            WEIGHT_UNITS -> MassUnits.values()
            CURRENCY_UNITS -> CurrencyUnits.values()
            TEMPERATURE_UNITS -> TemparatureUnits.values()
        }
    }
}

interface IUnits {
    fun getOrdinal(): Int
    fun getName(): String
}

enum class LengthUnits: IUnits {
    mm {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    cm {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    dm {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    m {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    dam {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    hm {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    km {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    miles {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    nauticalMiles {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
}

enum class MassUnits: IUnits {
    mg {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    cg {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    dg {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    g {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    dag {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    hg {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    kg {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    quintal {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    tone {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
}

enum class CurrencyUnits: IUnits {
    usDollars {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    poundSterling {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    euro {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    japaneseYen {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    indianRupee {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    chineseYuan {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    canadianDollars {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    uaeDirham {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    }
}

enum class TemparatureUnits: IUnits {
    kelvin {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    celcius {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
    fahrenheit {
        override fun getOrdinal(): Int = this.ordinal
        override fun getName(): String = this.name
    },
}

fun isMetric(ordinal: Int): Boolean {
    return ordinal <= 6
}

val currencyConversionList: List<String> = GeneratorMethods.getCurrencyConversionList()

object GeneratorMethods {
    fun getCurrencyConversionList(): List<String> {
        val list = mutableListOf<String>()
        for (source in CurrencyUnits.values()) {
            for (target in CurrencyUnits.values()) {
                if (source != target) {
                    list.add("${source.name}_to_${target.name}")
                }
            }
        }
        return list
    }
}