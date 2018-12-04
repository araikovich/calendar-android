package com.example.tigranchilingarian.android.domain

import com.example.tigranchilingarian.android.data.entity.TaskEntity
import com.example.tigranchilingarian.android.data.repository.TimeTableRepository
import kotlinx.coroutines.channels.BroadcastChannel

class TimeTableInteractor(private val timeTableRepository: TimeTableRepository) {

    val tasksChanel = BroadcastChannel<List<TaskEntity>>(10)

    suspend fun loadTasks(date: String) {
        val tasks = timeTableRepository.getTimeTable(date)
        tasksChanel.send(tasks)
    }
}