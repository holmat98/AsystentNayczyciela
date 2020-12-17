package com.example.asystentnayczyciela.Model.Repositories

import androidx.lifecycle.LiveData
import com.example.asystentnayczyciela.Model.Student
import com.example.asystentnayczyciela.Model.Test
import com.example.asystentnayczyciela.Model.TestDao

class TestRepository(val testDao: TestDao) {

    suspend fun add(test: Test)
    {
        testDao.insert(test)
    }

    suspend fun delete(test: Test)
    {
        testDao.delete(test)
    }

    suspend fun insert(test: Test)
    {
        testDao.insert(test)
    }

    fun getTests(studentid: Int) : LiveData<MutableList<Test>>
    {
        return  testDao.getTest(studentid)
    }

    fun getTeachersTest(teacherId: Int) : LiveData<MutableList<Test>>
    {
        return testDao.getTeachersTest(teacherId)
    }


}