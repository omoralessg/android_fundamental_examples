package com.example.androidfundamental.asynctask

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.androidfundamental.R
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

// imports cut out for brevity
class ReadWebpageAsyncTask : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_webpage_async_task)
        textView = findViewById(R.id.TextView01)
    }

    class DownloadWebPageTask :
        AsyncTask<String?, Void?, String>() {
        override fun doInBackground(vararg urls: String?): String {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(urls[0])
                .build()
            var response: Response? = null
            try {
                response = client.newCall(request).execute()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            if (response!!.isSuccessful) {
                try {
                    return response.body()?.string().toString()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            return "Download failed"
        }

        override fun onPostExecute(result: String) {
            textView?.text = result
        }
    }

    // Triggered via a button in your layout
    fun onClick(view: View?) {
        val task = DownloadWebPageTask()
        task.execute(*arrayOf("https://www.vogella.com/index.html"))
    }

    companion object {
        private var textView: TextView? = null
    }
}