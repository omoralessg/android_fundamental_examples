package com.example.androidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {

    var male = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)


        val radioGroup = findViewById<View>(R.id.gender) as RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.female -> {
                    male = false
                    group.findViewById<View>(R.id.male).alpha = 0.5f
                    group.findViewById<View>(R.id.female).alpha = 0.9f
                }
                R.id.male -> {
                    male = true
                    group.findViewById<View>(R.id.female).alpha = 0.5f
                    group.findViewById<View>(R.id.male).alpha = 0.9f
                }

            }
        }
    }

    fun onClick(view: View) {
      finish()
    }


    private fun getGender(gender: Boolean): String {
        when (gender) {
            true -> return "male"
            false -> return "female"
        }
    }

    override fun finish() {
        val intent = Intent()
        intent.putExtra(User.USER_NAME, username.text.toString())
        intent.putExtra(User.USER_GENDER, male)
        setResult(RESULT_OK, intent)
        super.finish()
    }
}
