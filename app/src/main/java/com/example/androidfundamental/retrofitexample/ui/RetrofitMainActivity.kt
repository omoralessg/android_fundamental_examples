package com.example.androidfundamental.retrofitexample.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamental.R
import com.example.androidfundamental.retrofitexample.adapter.RecyclerViewAdapter
import com.example.androidfundamental.retrofitexample.api.StackOverflowAPI
import com.example.androidfundamental.retrofitexample.model.Answer
import com.example.androidfundamental.retrofitexample.model.ListWrapper
import com.example.androidfundamental.retrofitexample.model.Question
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitMainActivity : Activity(), View.OnClickListener {
    private lateinit var stackoverflowAPI: StackOverflowAPI
    private var token: String? = null
    private lateinit var authenticateButton: Button
    private lateinit var questionsSpinner: Spinner
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.retrofit_activity_main)
        questionsSpinner = findViewById<View>(R.id.questions_spinner) as Spinner
        questionsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val question = parent.adapter.getItem(position) as Question
                stackoverflowAPI.getAnswersForQuestion(question.questionId)!!.enqueue(
                    answersCallback
                )
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        authenticateButton = findViewById<View>(R.id.authenticate_button) as Button
        recyclerView = findViewById<View>(R.id.list) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this@RetrofitMainActivity)
        createStackoverflowAPI()
        stackoverflowAPI.questions!!.enqueue(questionsCallback)
    }

    override fun onResume() {
        super.onResume()
        if (token != null) {
            authenticateButton.isEnabled = false
        }
    }

    private fun createStackoverflowAPI() {
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(StackOverflowAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        stackoverflowAPI = retrofit.create(StackOverflowAPI::class.java)
    }

    override fun onClick(v: View) {
        when (v.id) {
            android.R.id.text1 -> if (token != null) { //TODO
            } else {
                Toast.makeText(this, "You need to authenticate first", Toast.LENGTH_LONG).show()
            }
            R.id.authenticate_button -> {
            }
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent
    ) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            token = data.getStringExtra("token")
        }
    }



    var questionsCallback: Callback<ListWrapper<Question?>?> =
        object : Callback<ListWrapper<Question?>?> {
            override fun onResponse(
                call: Call<ListWrapper<Question?>?>?,
                response: Response<ListWrapper<Question?>?>
            ) {
                if (response.isSuccessful()) {
                    val questions: ListWrapper<Question?>? = response.body()
                    val arrayAdapter = ArrayAdapter(
                        this@RetrofitMainActivity,
                        android.R.layout.simple_spinner_dropdown_item,
                        questions?.items!!
                    )
                    questionsSpinner.adapter = arrayAdapter
                } else {
                    Log.d(
                        "QuestionsCallback",
                        "Code: " + response.code().toString() + " Message: " + response.message()
                    )
                }
            }

            override fun onFailure(call: Call<ListWrapper<Question?>?>?, t: Throwable) {
                t.printStackTrace()
            }
        }
    var answersCallback: Callback<ListWrapper<Answer?>?> =
        object : Callback<ListWrapper<Answer?>?> {
            override fun onResponse(
                call: Call<ListWrapper<Answer?>?>?,
                response: Response<ListWrapper<Answer?>?>
            ) {
                if (response.isSuccessful) {
                    val data: MutableList<Answer> = ArrayList()
                    data.addAll(response.body()?.items as MutableList<Answer>)
                    recyclerView.adapter = RecyclerViewAdapter(data)
                } else {
                    Log.d(
                        "QuestionsCallback",
                        "Code: " + response.code().toString() + " Message: " + response.message()
                    )
                }
            }

            override fun onFailure(call: Call<ListWrapper<Answer?>?>?, t: Throwable) {
                t.printStackTrace()
            }
        }
    var upvoteCallback: Callback<ResponseBody?> = object : Callback<ResponseBody?> {
        override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
            if (response.isSuccessful()) {
                Toast.makeText(this@RetrofitMainActivity, "Upvote successful", Toast.LENGTH_LONG).show()
            } else {
                Log.d(
                    "QuestionsCallback",
                    "Code: " + response.code().toString() + " Message: " + response.message()
                )
                Toast.makeText(
                    this@RetrofitMainActivity,
                    "You already upvoted this answer",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        override fun onFailure(call: Call<ResponseBody?>?, t: Throwable) {
            t.printStackTrace()
        }
    }
}
