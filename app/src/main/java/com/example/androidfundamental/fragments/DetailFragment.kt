package com.example.androidfundamental.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidfundamental.R

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_rssitem_detail,
            container, false
        )
    }

    fun setText(text: String?) {
        val view = getView()!!.findViewById(R.id.detailsText) as TextView
        view.text = text
    }
}