package com.example.tigranchilingarian.android.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
        @ColumnInfo(name = "id")
        @PrimaryKey(autoGenerate = true) val _id: Long? = null,
        val title: String,
        @ColumnInfo(name = "date") val date: String,
        val timeStart: String,
        val timeEnd: String
)