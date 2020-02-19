package com.example.androidfundamental

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidfundamental.util.loadImage
import kotlin.random.Random

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
        private val imageView:ImageView = view.findViewById(R.id.icon)
        fun bind(string: String) {
            firstLine.text = string
            secondLine.text = string
            imageView.loadImage("https://cdn.pixabay.com/photo/2016/11/22/07/27/purdue-university-1848563_1280.jpg")
        }
    }
}