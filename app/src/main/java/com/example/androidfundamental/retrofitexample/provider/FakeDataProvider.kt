package com.example.androidfundamental.retrofitexample.provider

import com.example.androidfundamental.retrofitexample.model.Answer

import com.example.androidfundamental.retrofitexample.model.Question


object FakeDataProvider {
    val questions: List<Question>
        get() {
            val questions: MutableList<Question> = ArrayList()
            for (i in 0..9) {
                val question = Question()
                question.questionId = i.toString()
                question.title = i.toString()
                question.body = i.toString() + "Body"
                questions.add(question)
            }
            return questions
        }

    val answers: List<Answer>
        get() {
            val answers: MutableList<Answer> = ArrayList()
            for (i in 0..9) {
                val answer = Answer()
                answer.answerId = i
                answer.accepted = false
                answer.score = i
                answers.add(answer)
            }
            return answers
        }
}