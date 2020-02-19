package com.example.androidfundamental.mvpsample.util

import io.reactivex.Scheduler

interface PostExecutionThread {

    fun getScheduler(): Scheduler

}