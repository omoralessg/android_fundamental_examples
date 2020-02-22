package com.example.androidfundamental.scheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import com.example.androidfundamental.services.LocalWordService

class TestJobService : JobService() {
    override fun onStartJob(params: JobParameters): Boolean {
        val service = Intent(applicationContext, LocalWordService::class.java)
        applicationContext.startService(service)
        Util.scheduleJob(applicationContext) // reschedule the job
        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        return true
    }

    companion object {
        private const val TAG = "SyncService"
    }
}