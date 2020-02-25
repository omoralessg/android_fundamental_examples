package com.example.androidfundamental

class  ConverterUtil {

    companion object{
        fun convertFahrenheitToCelsius(grade : Int): Float {

            val grades = grade-32 * 5/9
            return grades.toFloat()
        }

        fun convertCelsiusToFahrenheit(grade: Int) : Float{
            return (grade * (9/5) +32).toFloat()
        }



    }



}
