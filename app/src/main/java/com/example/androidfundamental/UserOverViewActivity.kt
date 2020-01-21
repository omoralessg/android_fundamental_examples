package com.example.androidfundamental

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_overview.*


class UserOverViewActivity : AppCompatActivity() {

    companion object{
        private val SUB_ACTIVITY_CREATE_USER = 10
        lateinit var user : User

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_overview)

        val userExists = false

        if(!userExists){
            val pickContactIntent = Intent(this, CreateUserActivity::class.java)
            startActivityForResult(pickContactIntent, SUB_ACTIVITY_CREATE_USER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode === SUB_ACTIVITY_CREATE_USER && resultCode === Activity.RESULT_OK) {
            val name =
                data?.getStringExtra(User.USER_NAME)
            val gender =
                data?.getBooleanExtra(User.USER_GENDER, false)
            user = name?.let { gender?.let { it1 -> User(it, it1) } }!!
            updateUserInterface()
        }
    }


    private fun updateUserInterface() {
        username.text = user.name
    }




}
