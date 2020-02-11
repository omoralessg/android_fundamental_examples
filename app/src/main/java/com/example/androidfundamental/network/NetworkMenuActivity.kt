package com.example.androidfundamental.network

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.retrofitexample.ui.RetrofitMainActivity
import kotlinx.android.synthetic.main.activity_network_menu.*

class NetworkMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_menu)
        btn_network.setOnClickListener {
            startActivity(Intent(this, NetworkActivity::class.java))
        }
        btn_retrofit.setOnClickListener{
            startActivity(Intent(this, RetrofitMainActivity::class.java))
        }
    }
}
