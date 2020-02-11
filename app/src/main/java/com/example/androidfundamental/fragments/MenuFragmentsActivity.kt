package com.example.androidfundamental.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import kotlinx.android.synthetic.main.activity_menu_fragments.*

class MenuFragmentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_fragments)
        btn_fragments.setOnClickListener {
            startActivity(Intent(this, RssfeedActivity::class.java))
        }
        btn_df.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
