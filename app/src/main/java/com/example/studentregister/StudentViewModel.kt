package com.example.studentregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import com.example.studentregister.db.Student
import com.example.studentregister.db.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(private val dao: StudentDao): ViewModel(){
    val Students = dao.getAllStudents()
    fun insertStudent(student: Student)= viewModelScope.launch {
        dao.insertStudent(student)
    }
    fun updateStudent(student: Student)= viewModelScope.launch {
        dao.updateStudent(student)
    }
    fun deleteStudent(student: Student)= viewModelScope.launch {
        dao.deleteStudent(student)
    }
}