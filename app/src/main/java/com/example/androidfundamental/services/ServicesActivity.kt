package com.example.androidfundamental.services

import android.app.ListActivity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.androidfundamental.R
import com.example.androidfundamental.services.LocalWordService.MyBinder

class ServicesActivity : ListActivity(), ServiceConnection {
    private var s: LocalWordService? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)
        wordList = mutableListOf()
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, wordList!!
        )
        listAdapter = adapter
    }

    override fun onResume() {
        super.onResume()
        val intent = Intent(this, LocalWordService::class.java)
        bindService(intent, this, Context.BIND_AUTO_CREATE)
    }

    override fun onPause() {
        super.onPause()
        unbindService(this)
    }

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var wordList: MutableList<String>
    fun onClick(view: View) {
        when (view.id) {
            R.id.updateList -> if (s != null) {
                Toast.makeText(
                    this, "Number of elements" + s!!.wordList.size,
                    Toast.LENGTH_SHORT
                ).show()
                wordList.clear()
                wordList.addAll(s!!.wordList)
                adapter.notifyDataSetChanged()
            }
            R.id.triggerServiceUpdate -> {
                val service = Intent(applicationContext, LocalWordService::class.java)
                applicationContext.startService(service)
            }
        }
    }

    override fun onServiceConnected(name: ComponentName, binder: IBinder) {
        val b = binder as MyBinder
        s = b.service
        Toast.makeText(this@ServicesActivity, "Connected", Toast.LENGTH_SHORT).show()
    }

    override fun onServiceDisconnected(name: ComponentName) {
        s = null
    }
}