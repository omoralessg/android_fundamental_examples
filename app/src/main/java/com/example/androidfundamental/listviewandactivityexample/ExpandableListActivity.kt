package com.example.androidfundamental.listviewandactivityexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import android.widget.ExpandableListView
import android.util.SparseArray
import android.app.Activity
import android.view.View


class ExpandableListActivity : Activity() {
    // more efficient than HashMap for mapping integers to objects
    internal var groups = SparseArray<Group>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.androidfundamental.R.layout.activity_expandable_list)
        createData()
        val listView = findViewById<View>(com.example.androidfundamental.R.id.listView) as ExpandableListView
        val adapter = ExpandableListAdapter(
            this,
            groups
        )
        listView.setAdapter(adapter)
    }

    fun createData() {
        for (j in 0..4) {
            val group = Group("Test $j")
            for (i in 0..4) {
                group.children.add("Sub Item$i")
            }
            groups.append(j, group)
        }
    }

}
