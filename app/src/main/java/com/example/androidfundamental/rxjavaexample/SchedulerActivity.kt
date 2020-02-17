package com.example.androidfundamental.rxjavaexample

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfundamental.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Callable

class SchedulerActivity : AppCompatActivity() {
    private lateinit var  subscription: Disposable
    private lateinit var progressBar: ProgressBar
    private lateinit var messagearea: TextView
    private lateinit var button: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureLayout()
        createObservable()
    }

    private fun createObservable() {}
    override fun onDestroy() {
        super.onDestroy()
        if (subscription != null && !subscription.isDisposed) {
            subscription.dispose()
        }
    }

    private fun configureLayout() {
        setContentView(R.layout.activity_scheduler)
        progressBar =
            findViewById<View>(R.id.progressBar) as ProgressBar
        messagearea = findViewById<View>(R.id.messagearea) as TextView
        button = findViewById(R.id.scheduleLongRunningOperation)
        button.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            Observable.fromCallable(callable)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { disposable: Disposable? ->
                    progressBar.visibility = View.VISIBLE
                    button.isEnabled = false
                    messagearea.text =
                        messagearea.text.toString() + "\n" + "Progressbar set visible"
                }.subscribe(disposableObserver)
        }
    }

    var callable =
        Callable { doSomethingLong() }

    fun doSomethingLong(): String {
        SystemClock.sleep(1000)
        return "Hello"
    }

    /**
     * Observer
     * Handles the stream of data:
     */
    private val disposableObserver: DisposableObserver<String?>
        private get() = object : DisposableObserver<String?>() {
            override fun onComplete() {
                messagearea.text = messagearea.text.toString() + "\n" + "OnComplete"
                progressBar.visibility = View.INVISIBLE
                button.isEnabled = true
                messagearea.text = messagearea.text.toString() + "\n" + "Hidding Progressbar"
            }

            override fun onError(e: Throwable) {
                messagearea.text = messagearea.text.toString() + "\n" + "OnError"
                progressBar.visibility = View.INVISIBLE
                button.isEnabled = true
                messagearea.text = messagearea.text.toString() + "\n" + "Hidding Progressbar"
            }

            override fun onNext(message: String) {
                messagearea.text = messagearea.text.toString() + "\n" + "onNext " + message
            }
        }
}