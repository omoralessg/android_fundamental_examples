package com.example.androidfundamental.listviewandactivityexample

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidfundamental.R

class ListExampleAdapter (private val context: Activity, private val values: Array<String>):
    ArrayAdapter<String>( context, R.layout.rowlayout){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.rowlayout, parent, false)
        val textView = rowView.findViewById<TextView>(R.id.label)
        val imageView = rowView.findViewById(R.id.icon) as ImageView
        textView.text = values[position]

        // Change the icon for Windows and iPhone
        val s = values[position]
        if (s.startsWith("Windows7") || s.startsWith("iPhone")
            || s.startsWith("Solaris")
        ) {
            imageView.setImageResource(android.R.drawable.ic_menu_help)
        } else {
            imageView.setImageResource(android.R.drawable.ic_menu_info_details)
        }

        return rowView
    }

    override fun getCount(): Int {
       return values.size
    }
}