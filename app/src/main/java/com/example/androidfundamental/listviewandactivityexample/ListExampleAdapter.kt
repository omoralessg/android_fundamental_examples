package com.example.androidfundamental.listviewandactivityexample

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidfundamental.R

class ListExampleAdapter (private val context: Activity, private val values: Array<String>):
    ArrayAdapter<String>( context, R.layout.rowlayout){

    internal class ViewHolder {
        var text: TextView? = null
        var image: ImageView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var rowView: View? = convertView
        // reuse views
        if (rowView == null) {
            val inflater = context.layoutInflater
            rowView = inflater.inflate(R.layout.rowlayout, null)
            val viewHolder = ViewHolder()
            viewHolder.text = rowView!!.findViewById(R.id.label)
            viewHolder.image = rowView!!.findViewById(R.id.icon) as ImageView
            rowView!!.setTag(viewHolder)
        }

        // fill data
        val holder = rowView!!.getTag() as ViewHolder
        val s = values[position]
        holder.text!!.text = s
        if (s.startsWith("Windows7") || s.startsWith("iPhone")
            || s.startsWith("Solaris")
        ) {
            holder.image!!.setImageResource(android.R.drawable.ic_menu_help)
        } else {
            holder.image!!.setImageResource(android.R.drawable.ic_menu_info_details)
        }
        return rowView
    }

    override fun getCount(): Int {
       return values.size
    }
}