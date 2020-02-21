package com.example.androidfundamental.widgetsample

import android.app.PendingIntent
import android.app.Service
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import com.example.androidfundamental.R
import java.util.*

class UpdateWidgetService : Service() {
    override fun onStart(intent: Intent, startId: Int) {
        val appWidgetManager = AppWidgetManager.getInstance(this.applicationContext)
        val allWidgetIds = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS)
        for (widgetId in allWidgetIds) { // create some random data
            val number = Random().nextInt(100)
            val remoteViews = RemoteViews(this.applicationContext.packageName, R.layout.widget_layout)
            Log.w("WidgetExample", number.toString())
            // Set the text
            remoteViews.setTextViewText(R.id.update, "Random: $number")
            // Register an onClickListener
            val clickIntent = Intent(this.applicationContext, MyWidgetProvider::class.java)
            clickIntent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
            clickIntent.putExtra(
                AppWidgetManager.EXTRA_APPWIDGET_IDS,
                allWidgetIds
            )
            val pendingIntent = PendingIntent.getBroadcast(
                applicationContext, 0, clickIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent)
            appWidgetManager.updateAppWidget(widgetId, remoteViews)
        }
        stopSelf()
        super.onStart(intent, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}