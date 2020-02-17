package com.example.androidfundamental.retrofitexample.github

import com.squareup.okhttp.ResponseBody
import io.reactivex.Single
import retrofit2.http.*

interface GithubAPI {
    @get:GET("user/repos?per_page=100")
    val repos: Single<List<GithubRepo?>?>?

    @GET("/repos/{owner}/{repo}/issues")
    fun getIssues(@Path("owner") owner: String?, @Path("repo") repository: String?): Single<List<GithubIssue?>?>?

    @POST
    fun postComment(@Url url: String?, @Body issue: GithubIssue?): Single<ResponseBody?>?

    companion object {
        const val ENDPOINT = "https://api.github.com"
    }
}