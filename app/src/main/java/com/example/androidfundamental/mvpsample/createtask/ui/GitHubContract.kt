package com.example.androidfundamental.mvpsample.createtask.ui

import com.example.androidfundamental.retrofitexample.github.GithubRepo


interface GitHubContract {
    interface View {
        fun showRepositories(repositories: List<GithubRepo?>?)
        fun showAddRepository()
        fun showRepositoryDetails(githubRepo: GithubRepo)
        fun showError(error: String)
        fun hideLoading()
        fun showLoading()
    }

    interface UserActionsListener {
        fun loadRepositories(forceUpdate: Boolean)
        fun addRepository()
        fun openRepositoryDetails(githubRepo: GithubRepo)
    }
}