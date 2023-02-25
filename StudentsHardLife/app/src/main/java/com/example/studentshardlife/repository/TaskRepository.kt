package com.example.studentshardlife.repository

import androidx.lifecycle.LiveData
import com.example.studentshardlife.data.TaskDao
import com.example.studentshardlife.model.Task

class TaskRepository(private val taskDao: TaskDao) {

    val readAllData: LiveData<List<Task>> = taskDao.readAllData()

    suspend fun addTask(task: Task){
        taskDao.addTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }
}