package com.example.androidfundamental.mvpsample.respositorydetail

import com.example.androidfundamental.mvpsample.base.BasePresenter
import com.example.androidfundamental.retrofitexample.github.GithubRepo

class RepositoryDetailPresenter(repositoryDetailView: RepositoryDetailView) :
    BasePresenter<RepositoryDetailView>(repositoryDetailView), RepositoryDetailContract.Presenter {
    override fun close() {
        view.close()
    }

    override fun showDetails(details: GithubRepo) {
        view.showDetails(details)
    }
}