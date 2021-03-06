package com.example.asystentnayczyciela.Model.Repositories

import androidx.lifecycle.LiveData
import com.example.asystentnayczyciela.Model.Grade
import com.example.asystentnayczyciela.Model.GradeDao
import com.example.asystentnayczyciela.Model.Student
import java.util.*

class GradeRepository(val gradeDao: GradeDao) {
    val readAll: LiveData<MutableList<Grade>> = gradeDao.allGrades()

    suspend fun add(grade: Grade) {
        gradeDao.insert(grade)
    }

    fun getStudentsGrades(studentId: Int, courseId: Int) : LiveData<MutableList<Grade>>
    {
        return gradeDao.getStudentsGrades(studentId, courseId)
    }

    fun getReport(todaysDate: String, teacherId: Int) : LiveData<MutableList<Grade>>{
        return gradeDao.report(todaysDate, teacherId)
    }

    suspend fun delete(grade: Grade) = gradeDao.delete(grade)
}