package com.example.androidfundamental.databindingexample.contract

import com.example.androidfundamental.databindingexample.model.TemperatureData

interface DataBindingExampleContract {

    interface View {
        fun showData(temperatureData: TemperatureData)
    }

    interface Presenter {
        fun onShowData(temperatureData: TemperatureData)
    }
}