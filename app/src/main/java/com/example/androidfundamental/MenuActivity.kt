package com.example.androidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.databindingexample.view.DataBindingExampleActivity
import com.example.androidfundamental.viewmodelexample.TaskActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        button_pr123.setOnClickListener {
            startActivity(Intent(this, UserOverViewActivity::class.java))
        }

        btn_recycler.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        btn_databinding.setOnClickListener {
            startActivity(Intent(this, DataBindingExampleActivity::class.java))
        }

        btn_view_model.setOnClickListener {
            startActivity(Intent(this, TaskActivity::class.java))
        }
    }
}
