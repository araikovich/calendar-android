package com.example.tigranchilingarian.android.data.repository.impl

import com.example.tigranchilingarian.android.data.entity.TaskEntity
import com.example.tigranchilingarian.android.data.repository.TimeTableRepository
import com.example.tigranchilingarian.android.data.storage.TimeTableStorage

class TimeTableRepositoryImpl(
        private val localDataSource: TimeTableStorage) : TimeTableRepository {

    override suspend fun getTimeTable(date: String): List<TaskEntity> {
        val tasks = localDataSource.getTimeTable(date)
        return if (tasks.isEmpty()) {
            tasks
            //TODO impliment remoteDataSource
        } else {
            tasks
        }
    }

    override suspend fun syncTimeTable(tasks: TaskEntity) {
    }

    override suspend fun saveTask(task: TaskEntity) {
    }
}