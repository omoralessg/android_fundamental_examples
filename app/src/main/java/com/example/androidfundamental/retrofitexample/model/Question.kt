package com.example.androidfundamental.retrofitexample.model

import com.google.gson.annotations.SerializedName

class Question {
     var title: String? = null
     var body: String? = null
    @SerializedName("question_id")
     var questionId: String? = null
}

    class Answer {
        @SerializedName("answer_id")
        var answerId: Int? = null
        @SerializedName("is_accepted")
        var accepted: Boolean? = null
        var score: Int? = null
}