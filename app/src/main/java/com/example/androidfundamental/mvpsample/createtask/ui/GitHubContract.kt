package com.example.androidfundamental.mvpsample.createtask.ui

interface GitHubContract {
    interface View {
        fun setProgressIndicator(active: Boolean)
        fun showRepositories(repositories: List<String>)
        fun showAddRepository()
        fun showRepositoryDetails(repositoryId: String?)
        fun showError(error: String)
        fun hideLoading()
        fun showLoading()
    }

    interface UserActionsListener {
        fun loadRepositories(forceUpdate: Boolean)
        fun addRepository()
        fun openRepositoryDetails(repositoryId: String?)
    }
}