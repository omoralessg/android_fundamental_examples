package com.example.androidfundamental.mvpsample.createtask.ui.presenter

import com.example.androidfundamental.R
import com.example.androidfundamental.mvpsample.base.BasePresenter
import com.example.androidfundamental.mvpsample.createtask.ui.GitHubContract
import com.example.androidfundamental.mvpsample.createtask.ui.view.TaskView
import com.example.androidfundamental.mvpsample.util.Api
import com.example.androidfundamental.mvpsample.util.PostExecutionThread
import com.example.androidfundamental.mvpsample.util.ThreadExecutor
import com.example.androidfundamental.retrofitexample.github.GithubRepo
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TaskActivityPresenter(
    taskView: TaskView,
    private val postExecutionThread: PostExecutionThread,
    private val threadExecutor: ThreadExecutor
) : BasePresenter<TaskView>(taskView),
    GitHubContract.UserActionsListener {

    @Inject
    lateinit var api: Api
    private var subscription: Disposable? = null

    override fun loadRepositories(forceUpdate: Boolean) {
        view.showLoading()
        subscription = api
            .repos
            ?.observeOn(postExecutionThread.getScheduler())
            ?.subscribeOn(Schedulers.from(threadExecutor))
            ?.doOnTerminate { view.hideLoading() }
            ?.subscribe(
                { data -> view.showRepositories(data) },
                { error -> view.showError(error.message ?: R.string.error.toString()) }
            )
    }

    private fun getList(data: List<GithubRepo?>?): List<String> {
        var repos = mutableListOf<String>()
        data?.forEach {
            it?.name?.let { it1 -> repos.add(it1) }
        }
        return repos
    }

    override fun addRepository() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openRepositoryDetails(githubRepo: GithubRepo) {
        view.showRepositoryDetails(githubRepo)
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}