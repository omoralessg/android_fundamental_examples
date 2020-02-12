package com.example.androidfundamental.roomexample

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.androidfundamental.R
import kotlinx.android.synthetic.main.activity_room_main.*

class MainRoomActivity : Activity(), View.OnClickListener {
    private lateinit var user: User
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_main)
        database = AppDatabase.getDatabase(context = applicationContext)!!
        // cleanup for testing some initial data
        database.userDao()?.let { userDao ->
            userDao.removeAllUsers()
            userDao.addUser(User(1, "Test 1", 1))
            user = userDao.allUser?.get(0) ?: User(0, "", 0)
            val trophy = Trophy(user.id.toLong(), "Learned to use 3")
            database.trophyDao()?.addTrophy(trophy)
            userDao.addUser(User(2, "Test 2", 2))
            userDao.addUser(User(3, "Test 3", 3))
        }
        updateFirstUserData()
        addtrophybutton.setOnClickListener(this)
        increaseskills.setOnClickListener(this)
    }

    private fun updateFirstUserData() {
        database.userDao()?.allUser?.let { userDao ->
            val user = userDao
            val trophiesperUser = user?.get(0)?.id?.let {
                database.trophyDao()?.findTrophiesForUser(
                    it
                )
            }
            val textView = findViewById<TextView>(R.id.result)
            Toast.makeText(this, trophiesperUser.toString(), Toast.LENGTH_SHORT).show()
            if (user.size > 0) {
                textView.text =
                    user?.get(0)?.name + " Skill points " + user?.get(0)?.skillPoints + " Trophys " + trophiesperUser?.size
            }
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.addtrophybutton) {
            Toast.makeText(this, user.id.toString(), Toast.LENGTH_SHORT).show()
            val trophy = Trophy(user.id.toLong(), "More stuff")
            database.trophyDao()?.let {
                it.addTrophy(trophy)
            }
        }
        if (view.id == R.id.increaseskills) {
            user.skillPoints++
            database.userDao()?.let {
                it.updateUser(user)
            }
        }
        updateFirstUserData()
    }

    override fun onDestroy() {
        AppDatabase.destroyInstance()
        super.onDestroy()
    }
}