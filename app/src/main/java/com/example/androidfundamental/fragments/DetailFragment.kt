package com.example.androidfundamental.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidfundamental.R
import kotlinx.android.synthetic.main.fragment_rssitem_detail.*

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = arguments
        val state = checkNotNull(bundle)
        if (!state.isEmpty) {
            val text = bundle.getString(EXTRA_TEXT)
            setText(text)
        }
    }

    fun setText(text: String?) {
        detailsText.text = text
    }

    companion object {
        const val EXTRA_TEXT = "text"
    }
}