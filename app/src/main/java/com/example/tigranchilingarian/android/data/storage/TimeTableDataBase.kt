package com.example.tigranchilingarian.android.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tigranchilingarian.android.data.entity.TaskEntity
import com.example.tigranchilingarian.android.data.entity.dao.TimeTableDao
import com.example.tigranchilingarian.android.di.module.CALENDAR_VERSION

@Database(entities = [TaskEntity::class], version = CALENDAR_VERSION)
abstract class TimeTableDataBase : RoomDatabase() {

    abstract fun timeTableDao(): TimeTableDao
}