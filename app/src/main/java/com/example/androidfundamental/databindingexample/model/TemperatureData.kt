package com.example.androidfundamental.databindingexample.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import com.example.androidfundamental.BR

class TemperatureData(loc: String, cel: String) : BaseObservable() {
    @get:Bindable
    var celsius: String = cel
    @get:Bindable
    var location: String = loc
}