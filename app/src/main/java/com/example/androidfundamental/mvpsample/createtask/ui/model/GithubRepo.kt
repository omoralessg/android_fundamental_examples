package com.example.androidfundamental.mvpsample.createtask.ui.model

class GithubRepo {
    @JvmField
    var name: String? = null
    @JvmField
    var owner: String? = null
    @JvmField
    var url: String? = null
    override fun toString(): String {
        return "$name $url"
    }
}