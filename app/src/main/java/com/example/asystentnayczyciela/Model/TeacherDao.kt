package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface TeacherDao {

    @Insert
    suspend fun insert(teacher: Teacher)

    @Delete
    suspend fun delete(teacher: Teacher)

    @Query("select * from teacher_table")
    fun allTeachers(): LiveData<MutableList<Teacher>>
}