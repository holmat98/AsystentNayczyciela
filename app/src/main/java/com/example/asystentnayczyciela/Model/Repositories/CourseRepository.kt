package com.example.asystentnayczyciela.Model.Repositories

import androidx.lifecycle.LiveData
import com.example.asystentnayczyciela.Model.Course
import com.example.asystentnayczyciela.Model.CourseDao
import com.example.asystentnayczyciela.Model.Student

class CourseRepository(val courseDao: CourseDao) {

    val readAll: LiveData<MutableList<Course>> = courseDao.allCourses()

    suspend fun insert(course: Course) {
        courseDao.insert(course)
    }

    fun getTeachersCourses(teacherId: Int) : LiveData<MutableList<Course>>
    {
        return courseDao.teachersCourses(teacherId)
    }

    fun getStudentsCourses(studentId: Int) : LiveData<MutableList<Course>>
    {
        return courseDao.studentsCourses(studentId)
    }

    suspend fun delete(course: Course)=courseDao.delete(course)
}