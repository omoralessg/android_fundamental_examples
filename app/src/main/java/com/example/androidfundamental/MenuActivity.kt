package com.example.androidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.fragments.MenuFragmentsActivity
import com.example.androidfundamental.fundamental.FundamentalActivity
import com.example.androidfundamental.network.NetworkMenuActivity
import com.example.androidfundamental.retrofitexample.ui.RetrofitMainActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btn_fundamental.setOnClickListener {
            startActivity(Intent(this, FundamentalActivity::class.java))
            }
        btn_android_network.setOnClickListener {
            startActivity(Intent(this, NetworkMenuActivity::class.java))
        }
        btn_fragments_toolbar.setOnClickListener {
            startActivity(Intent(this, MenuFragmentsActivity::class.java))
    }
}
}