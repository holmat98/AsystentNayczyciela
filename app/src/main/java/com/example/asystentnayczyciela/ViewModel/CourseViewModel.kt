package com.example.asystentnayczyciela.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.asystentnayczyciela.Model.AssistentDatabase
import com.example.asystentnayczyciela.Model.Course
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.Model.Repositories.CourseRepository
import com.example.asystentnayczyciela.Model.Repositories.StudentRepository
import kotlinx.coroutines.launch

class CourseViewModel(application: Application): AndroidViewModel(application) {

    val courses: LiveData<MutableList<Course>>
    val courseRepository: CourseRepository
    var teachersCourses: LiveData<MutableList<Course>>
    var studentsCourses: LiveData<MutableList<Course>>

    init{
        courses = AssistentDatabase.getDatabase(application).courseDao().allCourses()
        courseRepository = CourseRepository(AssistentDatabase.getDatabase(application).courseDao())
        teachersCourses = AssistentDatabase.getDatabase(application).courseDao().teachersCourses(DataSource.chosenTeacherId)
        studentsCourses = AssistentDatabase.getDatabase(application).courseDao().studentsCourses(DataSource.chosenStudentId)
    }

    fun addCourse(name: String, teacherId: Int)
    {
        viewModelScope.launch {
            courseRepository.insert(Course(name = name, idTeacher = teacherId, id = 0))
        }
    }

    fun deleteCourse(course: Course)
    {
        viewModelScope.launch {
            courseRepository.delete(course)
        }
    }


}