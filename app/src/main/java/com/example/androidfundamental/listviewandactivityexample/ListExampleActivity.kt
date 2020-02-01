package com.example.androidfundamental.listviewandactivityexample

import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.androidfundamental.R


class ListExampleActivity : ListActivity() {
    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        val values = arrayOf(
            "Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2"
        )
        // use your custom layout
        val adapter = ArrayAdapter(
            this,
            R.layout.rowlayout, R.id.label, values
        )
        listAdapter = adapter
    }

    override fun onListItemClick(
        l: ListView?,
        v: View?,
        position: Int,
        id: Long
    ) {
        val item = listAdapter.getItem(position) as String
        Toast.makeText(this, "$item selected", Toast.LENGTH_LONG).show()
    }
}