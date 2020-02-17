package com.example.androidfundamental.roomexample

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "trophy",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns =  ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["id"])]
)

 class Trophy(var userId: Long, var description: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

