package com.example.androidfundamental.mvpsample.data

import com.example.androidfundamental.mvpsample.createtask.model.GithubRepo
import com.squareup.okhttp.ResponseBody
import io.reactivex.Single
import retrofit2.http.*

interface GithubAPI {
    @get:GET("user/repos?per_page=100")
    val repos: Single<List<GithubRepo?>?>?

    companion object {
        const val ENDPOINT = "https://api.github.com"
    }
}