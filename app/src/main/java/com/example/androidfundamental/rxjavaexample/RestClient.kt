package com.example.androidfundamental.rxjavaexample

import android.content.Context
import android.os.SystemClock
import java.util.*

class RestClient(private val mContext: Context) {
    // "Simulate" the delay of network.
    val favoriteBooks: List<String>
        get() {
            SystemClock.sleep(8000) // "Simulate" the delay of network.
            return createBooks()
        }

    // "Simulate" the delay of network.
    val favoriteBooksWithException: List<String>
        get() {
            SystemClock.sleep(8000) // "Simulate" the delay of network.
            throw RuntimeException("Failed to load")
        }

    private fun createBooks(): List<String> {
        val books: MutableList<String> =
            ArrayList()
        books.add("Lord of the Rings")
        books.add("The dark elf")
        books.add("Eclipse Introduction")
        books.add("History book")
        books.add("Der kleine Prinz")
        books.add("7 habits of highly effective people")
        books.add("Other book 1")
        books.add("Other book 2")
        books.add("Other book 3")
        books.add("Other book 4")
        books.add("Other book 5")
        books.add("Other book 6")
        return books
    }

}