package com.example.androidfundamental.listviewandactivityexample

import android.widget.SimpleAdapter
import android.os.Bundle
import android.app.ListActivity


class TwoListItemsActivity : ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = buildData()
        val from = arrayOf("name", "purpose")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(
            this, list,
            android.R.layout.simple_list_item_2, from, to
        )
        listAdapter = adapter
    }

    private fun buildData(): ArrayList<Map<String, String>> {
        val list = ArrayList<Map<String, String>>()
        list.add(putData("Android", "Mobile"))
        list.add(putData("Windows7", "Windows7"))
        list.add(putData("iPhone", "iPhone"))
        return list
    }

    private fun putData(name: String, purpose: String): HashMap<String, String> {
        val item = HashMap<String, String>()
        item["name"] = name
        item["purpose"] = purpose
        return item
    }

}