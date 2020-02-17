package com.example.androidfundamental.roomexample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(@field:PrimaryKey val id: Int, var name: String, var skillPoints: Long) {
    var level = 0
}


