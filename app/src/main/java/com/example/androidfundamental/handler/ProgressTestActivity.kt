package com.example.androidfundamental.handler

import android.app.Activity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.example.androidfundamental.R

class ProgressTestActivity : Activity() {
    private lateinit var progress: ProgressBar
    private lateinit var text: TextView
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_test)
        progress = findViewById<View>(R.id.progressBar1) as ProgressBar
        text = findViewById<View>(R.id.textView1) as TextView
    }

    fun startProgress(view: View?) { // do something long
        val runnable = Runnable {
            for (i in 0..10) {
                doFakeWork()
                progress.post {
                    text.text = "Updating"
                    progress.progress = i
                }
            }
        }
        Thread(runnable).start()
    }

    // Simulating something timeconsuming
    private fun doFakeWork() {
        SystemClock.sleep(5000)
    }
}
