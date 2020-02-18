package com.example.androidfundamental.mvpsample.createtask

interface GitHubContract {
    interface View {
        fun setProgressIndicator(active: Boolean)
        fun showRepositories(repositories: List<String?>?)
        fun showAddRepository()
        fun showRepositoryDetails(repositoryId: String?)
    }

    interface UserActionsListener {
        fun loadRepositories(forceUpdate: Boolean)
        fun addRepository()
        fun openRepositoryDetails(repositoryId: String?)
    }
}