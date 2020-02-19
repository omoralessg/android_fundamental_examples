package com.example.androidfundamental

import com.example.androidfundamental.mvpsample.util.ThreadExecutor

class ImmediateThreadExecutor: ThreadExecutor {
    override fun execute(runnable: Runnable?) {
        runnable?.run()
    }
}