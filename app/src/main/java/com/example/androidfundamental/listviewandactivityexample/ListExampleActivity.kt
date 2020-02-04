package com.example.androidfundamental.listviewandactivityexample

import android.app.ListActivity
import android.os.Bundle

class ListExampleActivity : ListActivity() {
    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        val values = arrayOf(
            "Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2"
        )
        // use your custom layout
       /* val adapter = ArrayAdapter(
            this,
            R.layout.rowlayout, R.id.label, values
        )*/

        //Use your custom adapter
        val adap = ListExampleAdapter(this, values)
        listAdapter = adap
    }

}