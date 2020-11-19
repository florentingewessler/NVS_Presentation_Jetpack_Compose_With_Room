package com.example.nvs_student_app.data

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application.applicationContext,
        StudentDatabase::class.java,
        "db-notes"
    ).build()

    var students by mutableStateOf(listOf<Student>())
        private set

    init {
        val studentDao = StudentDatabase.getDatabase(application).studentDao()

        GlobalScope.launch {
            val items = db.studentDao().readAllData()
            viewModelScope.launch { students = items }
        }
    }

    fun addStudent(student: Student){
        GlobalScope.launch(Dispatchers.IO) {
            students = students + listOf(student)
            db.studentDao().addStudent(student)
        }
    }

    fun clearStudents(){
        GlobalScope.launch {
            students = listOf()
            db.studentDao().nukeTable()
        }
    }
}