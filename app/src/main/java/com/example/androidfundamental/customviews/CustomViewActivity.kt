package com.example.androidfundamental.customviews

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.example.androidfundamental.R

class CustomViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean { // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_main_custom_view, menu)
        return true
    }

    fun onClicked(view: View) {
        val text = if (view.id == R.id.view1) "Background" else "Foreground"
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}