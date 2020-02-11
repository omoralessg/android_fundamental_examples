package com.example.androidfundamental.rxjavaexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamental.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.*

class ColorsActivity : AppCompatActivity() {
    lateinit var colorListView: RecyclerView
    lateinit var simpleStringAdapter: SimpleStringAdapter
    private lateinit var disposable: Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureLayout()
        createObservable()
    }

    private fun createObservable() {
        val listObservable =
            Observable.just(colorList)
        disposable =
            listObservable.subscribe { colors: List<String> ->
                simpleStringAdapter.setStrings(
                    colors
                )
            }
    }

    private fun configureLayout() {
        setContentView(R.layout.activity_colors)
        colorListView = findViewById<View>(R.id.color_list) as RecyclerView
        colorListView.layoutManager = LinearLayoutManager(this)
        simpleStringAdapter = SimpleStringAdapter(this)
        colorListView.adapter = simpleStringAdapter
    }

    override fun onStop() {
        super.onStop()
        if (disposable != null && !disposable.isDisposed) {
            disposable.dispose()
        }
    }

    companion object {
        private val colorList: List<String>
            get() {
                val colors = ArrayList<String>()
                colors.add("red")
                colors.add("green")
                colors.add("blue")
                colors.add("pink")
                colors.add("brown")
                return colors
            }
    }
}