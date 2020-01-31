package com.example.androidfundamental.viewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TaskViewModel : ViewModel() {
    private var tasks: MutableLiveData<List<Task>>? = null

    fun getTasks(): LiveData<List<Task>> {
        if (tasks == null) {
            tasks =
                MutableLiveData()
            loadTasks()
        }
        return tasks as MutableLiveData<List<Task>>
    }

    private fun loadTasks() {
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        // do async operation to fetch users
        val list: MutableList<Task> =
            ArrayList()
        val task =
            Task.builder().setId(1)
                .setSummary("Testing ViewModel").build()
        list.add(task)
        tasks!!.value = list
    }
}
