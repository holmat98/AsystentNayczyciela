package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TeacherDao {

    @Insert
    suspend fun insert(teacher: Teacher)

    @Delete
    suspend fun delete(teacher: Teacher)

    @Query("select * from teacher_table")
    fun allTeachers() : LiveData<MutableList<Teacher>>

    @Query("update teacher_table set name = :newName, lastName = :newLastName where id = :idTeacher")
    fun editTeacher(newName: String, newLastName: String, idTeacher: Int)
}