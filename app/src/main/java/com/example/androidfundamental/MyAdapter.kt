package com.example.androidfundamental

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var values: MutableList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val string = values.get(position)
        holder.bind(string)
    }

    fun removeAt(position: Int) {
        values.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(string: String) {
            val firstLine = view.findViewById<TextView>(R.id.firstLine)
            val secondLine = view.findViewById<TextView>(R.id.secondLine)
            firstLine.text = string
            secondLine.text = string
        }
    }
}