package com.example.androidfundamental.rxjavaexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import kotlinx.android.synthetic.main.activity_main_rxjava.*

class MainRxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_rxjava)

        first.setOnClickListener {
            startActivity(Intent(this, RxJavaSimpleActivity::class.java))
        }
        second.setOnClickListener {
            startActivity(Intent(this, ColorsActivity::class.java))
        }
        third.setOnClickListener {
            startActivity(Intent(this, BooksActivity::class.java))
        }
        btn_scheduler.setOnClickListener {
            startActivity(Intent(this, SchedulerActivity::class.java))
        }
    }
}
