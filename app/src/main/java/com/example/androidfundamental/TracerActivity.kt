package com.example.androidfundamental

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


open class TracerActivity : AppCompatActivity() {
    private var notificationManager: NotificationManager? = null

    companion object {
        private const val TRACER = "tracer"
        private const val TAG = "TracerActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracer)
        createChannel()
        notify("onCreate")
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "onCreate called")
        }
    }

    override fun onPause() {
        super.onPause()
        notify("onPause")
        if (BuildConfig.DEBUG) {
            Log.v(TAG, "onPause called")
        }
    }

    override fun onResume() {
        super.onResume()
        notify("onResume")
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onResume called")
        }
    }

    override fun onStop() {
        super.onStop()
        notify("onStop")
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onStop called")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        notify("onDestroy")
        if (BuildConfig.DEBUG) {
            Log.w(TAG, "onDestroy called")
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        notify("onRestoreInstanceState")
        if (BuildConfig.DEBUG) {
            Log.wtf(TAG, "onRestoreInstanceState called")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        notify("onSaveInstanceState")
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "onSaveInstanceState called")
        }
    }

    private fun notify(methodName: String) {
        val name = TracerActivity::class.java.name
        val strings = name.split("\\.")
        val notificationBuilder = Notification.Builder(this, TRACER)

        val notification =
            notificationBuilder.setContentTitle(methodName + " " + strings[strings.size - 1])
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(name).build()
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager?.notify((System.currentTimeMillis().toInt()), notification)
    }

    private fun createChannel() {
        notificationManager =
            getSystemService(NotificationManager::class.java) as NotificationManager
        val id = "TRACER"
        val name = "Activity live cycle tracer"
        val description = "Allows to trace de activity lifecycle"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(id, name, importance)
        channel.description = description
        notificationManager!!.createNotificationChannel(channel)
    }
}
