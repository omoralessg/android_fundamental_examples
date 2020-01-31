package com.example.androidfundamental.databindingexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.androidfundamental.R
import com.example.androidfundamental.BR
import com.example.androidfundamental.databinding.ActivityDataBindingExampleBinding
import com.example.androidfundamental.databindingexample.contract.DataBindingExampleContract.View
import com.example.androidfundamental.databindingexample.model.TemperatureData
import com.example.androidfundamental.databindingexample.presenter.DataBindingExamplePresenter

class DataBindingExampleActivity : AppCompatActivity(), View {
    private var dataBindingExamplePresenter: DataBindingExamplePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding_example)
        dataBindingExamplePresenter = DataBindingExamplePresenter(this)
        val binding: ActivityDataBindingExampleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding_example)
        val temperatureData =
            TemperatureData(
                "Hamburg",
                "10"
            )
        binding.setVariable(BR.temp, temperatureData)
        binding.setVariable(BR.presenter, dataBindingExamplePresenter)
        binding.executePendingBindings()
    }

    override fun showData(temperatureData: TemperatureData) {
        val celsius = temperatureData.celsius
        Toast.makeText(this, celsius, Toast.LENGTH_LONG).show()
    }
}
