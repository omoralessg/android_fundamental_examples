package com.example.androidfundamental.listviewandactivityexample

import android.app.ListActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.androidfundamental.R

class SelectionSingleView : ListActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val values = arrayOf(
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "w",
            "x",
            "y",
            "z"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_multiple_choice, values
        )
        listAdapter = adapter
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        //listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(
            this,
            listView.checkedItemCount.toString(),
            Toast.LENGTH_LONG
        ).show()
        return true
    }
}