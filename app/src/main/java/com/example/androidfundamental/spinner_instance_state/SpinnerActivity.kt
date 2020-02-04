package com.example.androidfundamental.spinner_instance_state

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.androidfundamental.R

class SpinnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        val languages = resources.getStringArray(R.array.operating_systems)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if(spinner!=null){
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, languages)
            spinner.adapter = adapter
        }
    }
}
