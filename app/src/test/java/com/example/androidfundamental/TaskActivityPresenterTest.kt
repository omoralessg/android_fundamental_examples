package com.example.androidfundamental

import com.example.androidfundamental.mvpsample.createtask.ui.presenter.TaskActivityPresenter
import com.example.androidfundamental.mvpsample.createtask.ui.view.TaskView
import com.example.androidfundamental.mvpsample.util.Api
import com.example.androidfundamental.mvpsample.util.PostExecutionThread
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class TaskActivityPresenterTest {
    @Mock
    lateinit var api: Api
    @Mock
    lateinit var view: TaskView
    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    val taskActivityPresenter by lazy {
        TaskActivityPresenter(view, postExecutionThread, ImmediateThreadExecutor())
    }

    @Before
    fun setup(){
        Mockito.`when`(postExecutionThread.getScheduler()).thenReturn(Schedulers.trampoline())
    }
}