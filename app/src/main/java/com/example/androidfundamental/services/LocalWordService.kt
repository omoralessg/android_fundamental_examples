package com.example.androidfundamental.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.example.androidfundamental.services.LocalWordService
import java.util.*

class LocalWordService : Service() {
    private val mBinder: IBinder = MyBinder()
    private val resultList: MutableList<String> =
        ArrayList()
    private var counter = 1
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        addResultValues()
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        addResultValues()
        return mBinder
    }

    inner class MyBinder : Binder() {
        val service: LocalWordService
            get() = this@LocalWordService
    }

    val wordList: List<String>
        get() = resultList

    private fun addResultValues() {
        val random = Random()
        val input =
            arrayListOf("Linux", "Android", "iPhone", "Windows7")
        resultList.add(input[random.nextInt(3)] + " " + counter++)
        if (counter == Int.MAX_VALUE) {
            counter = 0
        }
    }
}