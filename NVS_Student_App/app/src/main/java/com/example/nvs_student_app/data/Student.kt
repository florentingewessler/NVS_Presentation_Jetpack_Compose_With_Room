package com.example.nvs_student_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstname: String,
    val lastName: String,
    val grade: Int
)