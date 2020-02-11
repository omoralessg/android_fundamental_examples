package com.example.androidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.databindingexample.view.DataBindingExampleActivity
import com.example.androidfundamental.fragments.MainActivity
import com.example.androidfundamental.fragments.MenuFragmentsActivity
import com.example.androidfundamental.fragments.RssfeedActivity
import com.example.androidfundamental.fundamental.FundamentalActivity
import com.example.androidfundamental.spinner_instance_state.SpinnerActivity
import com.example.androidfundamental.viewmodelexample.TaskActivity
import com.example.androidfundamental.listviewandactivityexample.*
import com.example.androidfundamental.network.NetworkActivity
import com.example.androidfundamental.network.NetworkMenuActivity
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