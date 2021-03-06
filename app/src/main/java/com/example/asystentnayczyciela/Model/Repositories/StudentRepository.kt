package com.example.asystentnayczyciela.Model.Repositories

import androidx.lifecycle.LiveData
import com.example.asystentnayczyciela.Model.Student
import com.example.asystentnayczyciela.Model.StudentDao

class StudentRepository(private val studentDao: StudentDao) {
    val readAll: LiveData<MutableList<Student>> = studentDao.allStudents()

    suspend fun add(student:Student) {
        studentDao.insert(student)
    }

    suspend fun delete(student:Student)=studentDao.delete(student)

    fun getNotParticipants(courseId: Int) : LiveData<MutableList<Student>>{
        return studentDao.getNotParticipants(courseId)
    }

    fun getParticipants(courseId: Int) : LiveData<MutableList<Student>>{
        return studentDao.getParticipants(courseId)
    }

    fun editStudent(newName: String, newLastName: String, idStudent: Int)=studentDao.editStudent(newName, newLastName, idStudent)
}