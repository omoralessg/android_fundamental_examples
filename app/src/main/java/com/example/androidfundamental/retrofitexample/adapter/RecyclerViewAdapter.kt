package com.example.androidfundamental.retrofitexample.adapter

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamental.retrofitexample.model.Answer


class RecyclerViewAdapter(private val data: List<Answer>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var text: TextView = v.findViewById(R.id.text1)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_selectable_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val answer = data[position]
        holder.text.text = answer.toString()
        holder.itemView.tag = answer.answerId
    }

    override fun getItemCount(): Int {
        return data.size
    }

}