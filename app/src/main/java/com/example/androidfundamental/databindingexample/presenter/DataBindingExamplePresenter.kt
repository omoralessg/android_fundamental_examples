package com.example.androidfundamental.databindingexample.presenter

import com.example.androidfundamental.databindingexample.contract.DataBindingExampleContract.View
import com.example.androidfundamental.databindingexample.contract.DataBindingExampleContract
import com.example.androidfundamental.databindingexample.model.TemperatureData

class DataBindingExamplePresenter(view: View) : DataBindingExampleContract.Presenter {
    private val view = view

    override fun onShowData(temperatureData: TemperatureData) {
        view.showData(temperatureData)
    }
}