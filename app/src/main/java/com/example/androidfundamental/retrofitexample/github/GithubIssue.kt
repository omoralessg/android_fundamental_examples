package com.example.androidfundamental.retrofitexample.github

import com.google.gson.annotations.SerializedName

class GithubIssue {
    var id: String? = null
    var title: String? = null
    var comments_url: String? = null
    @SerializedName("body")
    var comment: String? = null

    override fun toString(): String {
        return "$id - $title"
    }
}