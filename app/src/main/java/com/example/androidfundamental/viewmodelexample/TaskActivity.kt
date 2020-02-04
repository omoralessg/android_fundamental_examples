package com.example.androidfundamental.viewmodelexample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidfundamental.R

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        val model: TaskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        model.getTasks().observe(
            this@TaskActivity,
            object :
                Observer<List<Task?>?> {
                override fun onChanged(users: List<Task?>?) { // update UI
                    val textView = findViewById<TextView>(R.id.result)
                    textView.setText(model.getTasks().getValue()?.get(0).toString())
                }
            })
    }
}