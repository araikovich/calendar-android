package com.example.tigranchilingarian.android.data.entity.dao

import androidx.room.*
import com.example.tigranchilingarian.android.data.entity.TaskEntity

@Dao
interface TimeTableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: TaskEntity)

    @Delete
    fun delete(task: TaskEntity)

    @Query("SELECT * FROM TaskEntity WHERE date =:date")
    fun getTimeTable(date: String): List<TaskEntity>
}