package com.example.androidfundamental.databindingexample.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class TemperatureData(loc: String, cel: String) : BaseObservable() {
    var location: String = loc
    var celsius: String = cel

    @Bindable
    fun getlocation(): String {
        return location
    }

    @Bindable
    fun getcelsius(): String {
        return celsius
    }

}



