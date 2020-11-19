package com.example.nvs_student_app.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    suspend fun addStudent(student: Student)

    @Query("SELECT * FROM student ORDER BY id ASC")
    fun readAllData(): List<Student>

    @Query("DELETE FROM student")
    fun nukeTable()
}