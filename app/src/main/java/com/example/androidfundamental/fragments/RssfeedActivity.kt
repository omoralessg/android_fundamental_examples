package com.example.androidfundamental.fragments

import android.app.Activity
import android.os.Bundle
import com.example.androidfundamental.R


class RssfeedActivity : Activity(),
    MyListFragment.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rssfeed)
    }

    override fun onRssItemSelected(text: String?) {
        val fragment = fragmentManager
            .findFragmentById(R.id.detailFragment) as DetailFragment
        fragment.setText(text)
    }
}