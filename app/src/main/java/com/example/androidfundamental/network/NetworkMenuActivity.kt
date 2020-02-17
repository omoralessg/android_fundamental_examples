package com.example.androidfundamental.network

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.retrofitexample.ui.RetrofitMainActivity
import com.example.androidfundamental.rxjavaexample.MainRxActivity
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
        btn_rx_java.setOnClickListener{
            startActivity(Intent(this, MainRxActivity::class.java))
        }
    }
}
