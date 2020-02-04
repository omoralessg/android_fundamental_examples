package com.example.androidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.databindingexample.view.DataBindingExampleActivity
import com.example.androidfundamental.listviewandactivityexample.ListExampleActivity
import com.example.androidfundamental.listviewandactivityexample.SelectionSingleView
import com.example.androidfundamental.listviewandactivityexample.TwoListItemsActivity
import com.example.androidfundamental.listviewandactivityexample.UndoBarActivity
import com.example.androidfundamental.viewmodelexample.TaskActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        button_pr123.setOnClickListener {
            startActivity(Intent(this, UserOverViewActivity::class.java))
        }
        btn_recycler.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
        btn_databinding.setOnClickListener {
            startActivity(Intent(this, DataBindingExampleActivity::class.java))
        }

        btn_view_model.setOnClickListener {
            startActivity(Intent(this, TaskActivity::class.java))
        }
        btn_list_view.setOnClickListener {
            startActivity(Intent(this, ListExampleActivity::class.java))
        }
        btn_selection_single_view.setOnClickListener {
            startActivity(Intent(this, SelectionSingleView::class.java))
        }
        btn_undo.setOnClickListener {
            startActivity(Intent(this, UndoBarActivity::class.java))
        }
        btn_two_list_items.setOnClickListener {
            startActivity(Intent(this, TwoListItemsActivity::class.java))
        }
    }
}