package com.example.androidfundamental.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.RecyclerViewActivity
import com.example.androidfundamental.UserOverViewActivity
import com.example.androidfundamental.databindingexample.view.DataBindingExampleActivity
import com.example.androidfundamental.listviewandactivityexample.*
import com.example.androidfundamental.spinner_instance_state.SpinnerActivity
import com.example.androidfundamental.viewmodelexample.TaskActivity
import kotlinx.android.synthetic.main.activity_fundamental.*

class FundamentalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fundamental)
        button_pr123.setOnClickListener {
            startActivity(Intent(this, UserOverViewActivity::class.java))
        }
        btn_recycler.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        btn_list_view.setOnClickListener {
            startActivity(Intent(this, ListExampleActivity::class.java))
        }
        btn_selection_single_view.setOnClickListener {
            startActivity(Intent(this, SelectionSingleView::class.java))
        }
        btn_two_list_items.setOnClickListener {
            startActivity(Intent(this, TwoListItemsActivity::class.java))
        }
        btn_expandable_list_view.setOnClickListener {
            startActivity(Intent(this, ExpandableListActivity::class.java))
        }
        btn_undo.setOnClickListener {
            startActivity(Intent(this, UndoBarActivity::class.java))
        }
        btn_databinding.setOnClickListener {
            startActivity(Intent(this, DataBindingExampleActivity::class.java))
        }
        btn_spinner.setOnClickListener{
            startActivity(Intent(this, SpinnerActivity::class.java))
        }
        btn_view_model.setOnClickListener {
            startActivity(Intent(this, TaskActivity::class.java))
}
}
}
