package com.example.tigranchilingarian.android.data.repository

import com.example.tigranchilingarian.android.data.entity.TaskEntity

interface TimeTableRepository {

    suspend fun getTimeTable(date: String): List<TaskEntity>

    suspend fun syncTimeTable(tasks: TaskEntity)

    suspend fun saveTask(task: TaskEntity)
}