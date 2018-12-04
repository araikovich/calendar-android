package com.example.tigranchilingarian.android.data.storage.local

import com.example.tigranchilingarian.android.data.entity.TaskEntity
import com.example.tigranchilingarian.android.data.storage.TimeTableDataBase
import com.example.tigranchilingarian.android.data.storage.TimeTableStorage

class TimeTableLocalStorage(private val db: TimeTableDataBase) : TimeTableStorage {

    override suspend fun getTimeTable(date: String): List<TaskEntity> {
        return db.timeTableDao().getTimeTable(date)
    }

    override suspend fun syncTimeTable(tasks: TaskEntity) {

    }

    override suspend fun saveTask(task: TaskEntity) {

    }
}