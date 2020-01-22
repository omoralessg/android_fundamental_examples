package com.example.androidfundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TracerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracer)
        notify("onCreate")
    }

    override fun onPause() {
        super.onPause()
        notify("onPause")

    }

    override fun onResume() {
        super.onResume()
        notify("onResume")
    }

    override fun onStop() {
        super.onStop()
        notify("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        notify("onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        notify("onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        notify("onSaveInstanceState")
    }

    private fun notify(methodName: String) {


    }
}
