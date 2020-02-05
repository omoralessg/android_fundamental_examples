package com.example.androidfundamental.fragments
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.androidfundamental.R

class RssfeedActivity : FragmentActivity(),
    ListFragment.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rssfeed)
    }

    override fun onRssItemSelected(text: String?) {
        val callingFragment = getSupportFragmentManager().findFragmentById(R.id.detailFragment) as DetailFragment
        callingFragment.setText(text)
    }
}