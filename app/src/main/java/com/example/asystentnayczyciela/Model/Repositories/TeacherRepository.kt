package com.example.asystentnayczyciela.Model.Repositories

import androidx.lifecycle.LiveData
import com.example.asystentnayczyciela.Model.Student
import com.example.asystentnayczyciela.Model.Teacher
import com.example.asystentnayczyciela.Model.TeacherDao

class TeacherRepository(private val teacherDao: TeacherDao) {
    val readAll: LiveData<MutableList<Teacher>> = teacherDao.allTeachers()

    suspend fun add(teacher: Teacher) {
        teacherDao.insert(teacher)
    }

    suspend fun delete(teacher: Teacher)=teacherDao.delete(teacher)
}