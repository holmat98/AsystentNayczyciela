package com.example.asystentnayczyciela.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.asystentnayczyciela.Model.AssistentDatabase
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.Model.Repositories.TestRepository
import com.example.asystentnayczyciela.Model.Test
import kotlinx.coroutines.launch

class TestViewModel(application: Application): AndroidViewModel(application) {

    var teachersTest: LiveData<MutableList<Test>>
    var tests: LiveData<MutableList<Test>>
    val testRepository: TestRepository

    init{
        tests = AssistentDatabase.getDatabase(application).testDao().getTest(DataSource.chosenStudentId)
        teachersTest = AssistentDatabase.getDatabase(application).testDao().getTeachersTest(DataSource.chosenTeacherId)
        testRepository = TestRepository(AssistentDatabase.getDatabase(application).testDao())
    }

    fun addTest(courseId: Int, topic: String, date: String)
    {
        viewModelScope.launch {
            testRepository.add(Test(id = 0, idCourse = courseId, topic = topic, testDate = date, isActive = true))
        }
    }

    fun deleteTest(test: Test)
    {
        viewModelScope.launch {
            testRepository.delete(test)
        }
    }

    fun updateTest(test: Test)
    {
        viewModelScope.launch {
            testRepository.insert(test)
        }
    }
}