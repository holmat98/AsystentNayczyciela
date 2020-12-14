package com.example.asystentnayczyciela.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.asystentnayczyciela.Model.AssistentDatabase
import com.example.asystentnayczyciela.Model.Repositories.TeacherRepository
import com.example.asystentnayczyciela.Model.Student
import com.example.asystentnayczyciela.Model.Teacher
import kotlinx.coroutines.launch

class TeacherViewModel(application: Application): AndroidViewModel(application) {
    val teachers: LiveData<MutableList<Teacher>>
    private val teacherRepository: TeacherRepository

    init{
        teachers = AssistentDatabase.getDatabase(application).teacherDao().allTeachers()
        teacherRepository = TeacherRepository(AssistentDatabase.getDatabase(application).teacherDao())
    }

    fun addTeacher(name: String, lastName: String)
    {
        viewModelScope.launch {
            teacherRepository.add(Teacher(name=name, lastName = lastName, id=0))
        }
    }

    fun deleteTeacher(teacher: Teacher){
        viewModelScope.launch {
            teacherRepository.delete(teacher)
        }
    }

    fun editTeacher(newName: String, newLastName: String, idTeacher: Int) {
        viewModelScope.launch {
            teacherRepository.editTeacher(newName = newName,newLastName = newLastName,idTeacher = idTeacher)
        }
    }
}