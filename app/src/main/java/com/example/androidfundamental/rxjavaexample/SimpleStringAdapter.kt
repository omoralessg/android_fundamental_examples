package com.example.androidfundamental.rxjavaexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamental.R
import java.util.*

class SimpleStringAdapter(private val mContext: Context) :
    RecyclerView.Adapter<SimpleStringAdapter.ViewHolder>() {
    private val mStrings: MutableList<String> =
        ArrayList()

    fun setStrings(newStrings: List<String>) {
        mStrings.clear()
        mStrings.addAll(newStrings)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.string_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.colorTextView.text = mStrings[position]
        holder.itemView.setOnClickListener {
            Toast.makeText(
                mContext,
                mStrings[position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return mStrings.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val colorTextView: TextView = view.findViewById<View>(R.id.color_display) as TextView
        }
}