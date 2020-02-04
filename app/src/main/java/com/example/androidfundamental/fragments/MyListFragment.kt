package com.example.androidfundamental.fragments

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.androidfundamental.R


class MyListFragment : Fragment() {
    private var listener: OnItemSelectedListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(
            R.layout.fragment_rsslist_overview,
            container, false
        )
        val button: Button = view.findViewById(R.id.updateButton) as Button
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                updateDetail("testing")
            }
        })
        return view
    }

    interface OnItemSelectedListener {
        fun onRssItemSelected(text: String?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is OnItemSelectedListener) {
            context
        } else {
            throw ClassCastException(
                context.toString()
                    .toString() + " must implement MyListFragment.OnItemSelectedListener"
            )
        }
    }

    // triggers update of the details fragment
    fun updateDetail(uri: String) { // create fake data
        val newTime =
            System.currentTimeMillis().toString() + uri
        // send data to activity
        listener!!.onRssItemSelected(newTime)
    }
}