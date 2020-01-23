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

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var firstLine: TextView = view.findViewById(R.id.firstLine)
        private val secondLine: TextView = view.findViewById(R.id.secondLine)

        fun bind(string: String) {
            firstLine.text = string
            secondLine.text = string
        }
    }
}