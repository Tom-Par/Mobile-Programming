package com.example.studentshardlife.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "task_table")
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Name: String,
    val Major: String,
    val Description: String
    ): Parcelable
