package com.example.androidfundamental.listviewandactivityexample

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.androidfundamental.R

class UndoBarActivity: AppCompatActivity()  {

    private var viewContainer: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_undo_bar)


        // Get the support action bar
        val actionBar = supportActionBar
        actionBar?.show()

        // Set the action bar title, subtitle and elevation
        actionBar!!.title = "Kotlin"
        actionBar.subtitle = "Many useful kotlin examples."
        actionBar.elevation = 4.0F

        val l = findViewById<View>(R.id.listview) as ListView
        val values = arrayOf(
            "Ubuntu",
            "Android",
            "iPhone",
            "Windows",
            "Ubuntu",
            "Android",
            "iPhone",
            "Windows"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, values
        )

        viewContainer = findViewById(R.id.undobar)
        l.setAdapter(adapter)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        showUndo(viewContainer!!)
        return true
    }

    fun onClick(view: View) {
        Toast.makeText(this, "Deletion undone", Toast.LENGTH_LONG).show()
        viewContainer!!.setVisibility(View.GONE)
    }

    companion object {

        fun showUndo(viewContainer: View) {
            viewContainer.setVisibility(View.VISIBLE)
            viewContainer.setAlpha(1f)
            viewContainer.animate().alpha(0.4f).setDuration(5000)
                .withEndAction(Runnable { viewContainer.setVisibility(View.GONE) })

        }
    }
}