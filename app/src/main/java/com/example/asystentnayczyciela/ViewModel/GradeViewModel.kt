package com.example.asystentnayczyciela.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.asystentnayczyciela.Model.AssistentDatabase
import com.example.asystentnayczyciela.Model.Course
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.Model.Grade
import com.example.asystentnayczyciela.Model.Repositories.CourseRepository
import com.example.asystentnayczyciela.Model.Repositories.GradeRepository
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.*

class GradeViewModel(application: Application): AndroidViewModel(application) {

    val grades: LiveData<MutableList<Grade>>
    val gradeRepository: GradeRepository
    var studentsGrades: LiveData<MutableList<Grade>>

    init{
        grades = AssistentDatabase.getDatabase(application).gradeDao().allGrades()
        gradeRepository = GradeRepository(AssistentDatabase.getDatabase(application).gradeDao())
        studentsGrades = AssistentDatabase.getDatabase(application).gradeDao().getStudentsGrades(DataSource.chosenStudentId)
    }

    fun addGrade(studentId: Int, description: String, courseId: Int, grade: String, date: Date)
    {
        viewModelScope.launch {
            gradeRepository.add(Grade(id = 0, idCourse = courseId, idStudent = studentId, gradeDescription = description, gradeValue = grade, date = date))
        }
    }

    fun deleteGrade(grade: Grade)
    {
        viewModelScope.launch {
            gradeRepository.delete(grade)
        }
    }

}