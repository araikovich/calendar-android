package com.example.tigranchilingarian.android.data.storage

import com.example.tigranchilingarian.android.data.entity.TaskEntity

interface TimeTableStorage {

    suspend fun getTimeTable(date: String): List<TaskEntity>

    suspend fun syncTimeTable(tasks: TaskEntity)

    suspend fun saveTask(task: TaskEntity)
}