package com.example.androidfundamental

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Assert
import org.junit.Test

class RxJavaUnitTest2 {
    var result = ""
    // Simple subscription to a fix value
    @Test
    fun returnAValue() {
        result = ""
        val observer =
            Observable.just("Hello") // provides data
        observer.subscribe { s: String ->
            result = s
        } // Callable as subscriber
        Assert.assertTrue(result == "Hello")
    }

    @Test
    fun expectNPE() {
        val todoObservable =
            Observable.create<Todo> { emitter ->
                try {
                    val todos =
                        todos
                            ?: throw NullPointerException("todos was null")
                    for (todo in todos) {
                        emitter.onNext(todo)
                    }
                    emitter.onComplete()
                } catch (e: Exception) {
                    emitter.onError(e)
                }
            }
        val testObserver = TestObserver<Any>()
        todoObservable.subscribeWith(testObserver)
        // expect a NPE by using the TestObserver
        testObserver.assertError(NullPointerException::class.java)
    }

    private val todos: List<Todo>?
        private get() = null

    inner class Todo
}