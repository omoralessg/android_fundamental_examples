package com.example.androidfundamental

import com.example.androidfundamental.mvpsample.createtask.ui.presenter.TaskActivityPresenter
import com.example.androidfundamental.mvpsample.createtask.ui.view.TaskView
import com.example.androidfundamental.mvpsample.util.Api
import com.example.androidfundamental.mvpsample.util.PostExecutionThread
import com.example.androidfundamental.retrofitexample.github.GithubRepo
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
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

    private val taskActivityPresenter by lazy {
        TaskActivityPresenter(view, postExecutionThread, ImmediateThreadExecutor())
    }

    @Before
    fun setup() {
        Mockito.`when`(postExecutionThread.getScheduler()).thenReturn(Schedulers.trampoline())
        taskActivityPresenter.api = api
    }

    @Test
    fun testLoadRepositoriesSuccess() {
        val list = listOf(GithubRepo().apply {
            name = "Android"
            owner = "omoralessg"
            url = "http://github.com/android.git"
        })
        Mockito.`when`(api.repos).thenReturn(Single.just(list))
        taskActivityPresenter.loadRepositories(true)
        Mockito.verify(view).showLoading()
        Mockito.verify(view).showRepositories(list)
        Mockito.verify(view).hideLoading()
        Mockito.verifyNoMoreInteractions(view)
    }

    @Test
    fun testLoadRepositoriesError() {
        val errorMockMessage = "Not found"
        Mockito.`when`(api.repos).thenReturn(Single.error(Throwable(errorMockMessage)))
        taskActivityPresenter.loadRepositories(true)
        Mockito.verify(view).showLoading()
        Mockito.verify(view).showError(errorMockMessage)
        Mockito.verify(view).hideLoading()
        Mockito.verifyNoMoreInteractions(view)
    }
}