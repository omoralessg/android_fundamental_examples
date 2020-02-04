package com.example.androidfundamental.listviewandactivityexample

import android.widget.CheckedTextView

import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import android.widget.TextView
import android.util.SparseArray
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.widget.BaseExpandableListAdapter
import com.example.androidfundamental.R


class ExpandableListAdapter(var activity: Activity, private val groups: SparseArray<Group>) :
    BaseExpandableListAdapter() {
    var inflater: LayoutInflater

    init {
        inflater = activity.layoutInflater
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return groups.get(groupPosition).children[childPosition]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return 0
    }

    override fun getChildView(
        groupPosition: Int, childPosition: Int,
        isLastChild: Boolean, convertView: View?, parent: ViewGroup
    ): View {
        var convertView = convertView
        val children = getChild(groupPosition, childPosition) as String
        var text: TextView? = null
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_details, null)
        }
        text = convertView!!.findViewById(R.id.textView1)
        text!!.text = children
        convertView.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                activity, children,
                Toast.LENGTH_SHORT
            ).show()
        })
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return groups.get(groupPosition).children.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return groups.get(groupPosition)
    }

    override fun getGroupCount(): Int {
        return groups.size()
    }

    override fun onGroupCollapsed(groupPosition: Int) {
        super.onGroupCollapsed(groupPosition)
    }

    override fun onGroupExpanded(groupPosition: Int) {
        super.onGroupExpanded(groupPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return 0
    }

    override fun getGroupView(
        groupPosition: Int, isExpanded: Boolean,
        convertView: View?, parent: ViewGroup
    ): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_group, null)
        }
        val group = getGroup(groupPosition) as Group
        (convertView as CheckedTextView).text = group.string
        (convertView as CheckedTextView).isChecked = isExpanded
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }
}