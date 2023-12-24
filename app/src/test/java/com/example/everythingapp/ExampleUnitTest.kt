package com.example.everythingapp

import com.example.everythingapp.converter.util.LengthUnits
import com.example.everythingapp.converter.util.lengthConvert
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.DecimalFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun unitConversions() {
        assertEquals(22000.0, lengthConvert(22.0, LengthUnits.km, LengthUnits.m), 0.0)
        assertEquals(22.0, lengthConvert(22000.0, LengthUnits.m, LengthUnits.km), 0.0)
        assertEquals(13.67, lengthConvert(22.0, LengthUnits.km, LengthUnits.miles), 0.001)
        assertEquals(22.0, lengthConvert(13.67, LengthUnits.miles, LengthUnits.km), 0.001)
    }

    private fun truncateTo4DecimalPlaces(value: Double): String {
        val df = DecimalFormat("#.######")
        return df.format(value)
    }

    @Test
    fun testTruncations() {
        assertEquals("0.0003", truncateTo4DecimalPlaces(lengthConvert(0.3, LengthUnits.m, LengthUnits.km)))
    }
}