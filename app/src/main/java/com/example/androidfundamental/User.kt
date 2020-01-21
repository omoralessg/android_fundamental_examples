package com.example.androidfundamental

import android.os.Bundle

class User{

    lateinit var name: String
    var gender: Boolean = false
    var skillspoint: Int = 0


    companion object {
        val USER_NAME = "username"
        val USER_GENDER = "gender"
        val USER_SKILL_POINTS = "skillPoints"

    }

    constructor(  name : String, gender: Boolean){
        this.name = name
        this.gender = gender
        this.skillspoint = 0
    }

}