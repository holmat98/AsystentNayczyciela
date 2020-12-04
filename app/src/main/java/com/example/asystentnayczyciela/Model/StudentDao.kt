package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("select * from student_table")
    fun allStudents() : LiveData<ArrayList<Student>>
}