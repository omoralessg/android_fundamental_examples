package com.example.androidfundamental

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class TracerActivity : AppCompatActivity() {
    private var notificationManager: NotificationManager? = null

    companion object{
        private const val TRACER = "tracer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracer)
        createChannel()
        notify("onCreate")
    }

    override fun onPause() {
        super.onPause()
        notify("onPause")
    }

    override fun onResume() {
        super.onResume()
        notify("onResume")
    }

    override fun onStop() {
        super.onStop()
        notify("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        notify("onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        notify("onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        notify("onSaveInstanceState")
    }

    private fun notify(methodName: String) {
        val name = TracerActivity::class.java.name
        val strings = name.split("\\.")
        val notificationBuilder = Notification.Builder(this, TRACER)

        val notification = notificationBuilder.setContentTitle(methodName + " " + strings[strings.size -1])
            .setAutoCancel(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText(name).build()
       val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)  as NotificationManager
        notificationManager?.notify((System.currentTimeMillis().toInt()), notification)

    }

    private fun createChannel() {
        notificationManager = getSystemService(NotificationManager::class.java) as NotificationManager
        val id = "TRACER"
        val name = "Activity live cycle tracer"
        val description = "Allows to trace de activity lifecycle"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(id, name, importance)
        channel.description = description
        notificationManager!!.createNotificationChannel(channel)
    }
}
