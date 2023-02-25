package com.example.studentshardlife.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.studentshardlife.model.Task


@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Task>>
}