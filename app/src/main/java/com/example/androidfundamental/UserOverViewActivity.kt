package com.example.androidfundamental

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_overview.*


class UserOverViewActivity : TracerActivity() {
    private lateinit var user : User
    companion object{
        private const val SUB_ACTIVITY_CREATE_USER = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_overview)
        val userExists = false
        if (!userExists) {
            val pickContactIntent = Intent(this, CreateUserActivity::class.java)
            startActivityForResult(pickContactIntent, SUB_ACTIVITY_CREATE_USER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode === SUB_ACTIVITY_CREATE_USER && resultCode === Activity.RESULT_OK) {
            val name = data?.getStringExtra(User.USER_NAME)
            val gender = data?.getBooleanExtra(User.USER_GENDER, false)
            user = name?.let { gender?.let { it1 -> User(it, it1) } }!!
            updateUserInterface()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun updateUserInterface() {
        username.text = user.name
    }
}
