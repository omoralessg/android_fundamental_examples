package com.example.androidfundamental.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidfundamental.R


    fun ImageView.loadImage(uri: String?) {
        Glide.with(this.context)
            .load(uri)
            .into(this)
    }
