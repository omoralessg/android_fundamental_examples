package com.example.androidfundamental.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.androidfundamental.R

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {
    private lateinit var listener: OnItemSelectedListener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(
            R.layout.fragment_rsslist_overview,
            container, false
        )
        val button: Button = view.findViewById(R.id.updateButton) as Button
        button.setOnClickListener {
            updateDetail("testing")
        }
        return view
    }

    interface OnItemSelectedListener {
        fun onRssItemSelected(text: String?)
    }

    override fun onAttach(context: Context) {
        listener = if (context is OnItemSelectedListener) {
            context
        } else {
            throw ClassCastException(
                context.toString() + { " must implement MyListFragment.OnItemSelectedListener" }
            )
        }
        super.onAttach(context)
    }

    // triggers update of the details fragment
    private fun updateDetail(uri: String) { // create fake data
        val newTime =
            System.currentTimeMillis().toString() + uri
        // send data to activity
        listener.onRssItemSelected(newTime)
    }
}