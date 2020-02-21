package com.example.androidfundamental.widgetsample

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log


class MyWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        Log.w(LOG, "onUpdate method called")
        // Get all ids
        val thisWidget = ComponentName(
            context,
            MyWidgetProvider::class.java
        )
        val allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget)
        // Build the intent to call the service
        val intent = Intent(
            context.applicationContext,
            UpdateWidgetService::class.java
        )
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds)
        // Update the widgets via the service
        context.startService(intent)
    }

    companion object {
        private const val LOG = "widget.example"
    }
}