package com.example.androidfundamental.rxjavaexample

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamental.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class BooksActivity : AppCompatActivity() {
    private lateinit var bookSubscription: Disposable
    private lateinit var booksRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var stringAdapter: SimpleStringAdapter
    private lateinit var restClient: RestClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restClient = RestClient(this)
        configureLayout()
        createObservable()
    }

    private fun createObservable() {
        val booksObservable =
            Observable.fromCallable { restClient.favoriteBooks }
        bookSubscription =
            booksObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe { strings: List<String> ->
                    displayBooks(
                        strings
                    )
                }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (bookSubscription != null && !bookSubscription.isDisposed) {
            bookSubscription.dispose()
        }
    }

    private fun displayBooks(books: List<String>) {
        stringAdapter.setStrings(books)
        progressBar.visibility = View.GONE
        booksRecyclerView.visibility = View.VISIBLE
    }

    private fun configureLayout() {
        setContentView(R.layout.activity_books)
        progressBar = findViewById<View>(R.id.loader) as ProgressBar
        booksRecyclerView = findViewById<View>(R.id.books_list) as RecyclerView
        booksRecyclerView.layoutManager = LinearLayoutManager(this)
        stringAdapter = SimpleStringAdapter(this)
        booksRecyclerView.adapter = stringAdapter
    }

    override fun onStop() {
        super.onStop()
        if (bookSubscription != null && !bookSubscription.isDisposed) {
            bookSubscription.dispose()
        }
    }
}