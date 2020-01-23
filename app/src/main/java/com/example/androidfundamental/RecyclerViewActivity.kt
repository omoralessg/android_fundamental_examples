package com.example.androidfundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val stringList =
            listOf("Element1", "Element2", "Element3", "Element4", "Element5").toMutableList()
        recyclerAdapter = MyAdapter(stringList)

        val swipH = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recyclerView.adapter as MyAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipH)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            val mLayoutManager = LinearLayoutManager(context)
            val divider = DividerItemDecoration(context, mLayoutManager.orientation)
            addItemDecoration(divider)
            layoutManager = mLayoutManager
            adapter = recyclerAdapter
        }
    }
}
