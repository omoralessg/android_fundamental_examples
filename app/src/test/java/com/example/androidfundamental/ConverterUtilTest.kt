package com.example.androidfundamental

import junit.framework.Assert.assertEquals
import org.junit.Test

class ConverterUtilTest {
    @Test
    fun testConvertFahrenheitToCelsius() {
        val actual: Float = ConverterUtil.convertCelsiusToFahrenheit(100)
        // expected value is 212
        val expected = 212f
        // use this method because float is not precise
        assertEquals("Conversion from celsius to fahrenheit failed",
            expected, actual, 0.001f)
    }

    @Test
    fun testConvertCelsiusToFahrenheit() {
        val actual: Float = ConverterUtil.convertFahrenheitToCelsius(212)
        // expected value is 100
        val expected = 100f
        // use this method because float is not precise
        assertEquals("Conversion from celsius to fahrenheit failed",
            expected, actual, 0.001f)
    }
}
