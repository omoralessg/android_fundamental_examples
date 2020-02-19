package com.example.androidfundamental.mvpsample.respositorydetail

import com.example.androidfundamental.retrofitexample.github.GithubRepo

interface RepositoryDetailContract {
    interface View {
        fun showDetails(details: GithubRepo)
        fun close()
    }

    interface Presenter {
        fun close()
        fun showDetails(details: GithubRepo)
    }
}