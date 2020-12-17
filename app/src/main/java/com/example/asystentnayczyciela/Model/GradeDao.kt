package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface GradeDao {
    @Insert
    suspend fun insert(grade: Grade)

    @Delete
    suspend fun delete(grade: Grade)

    @Query("select * from grade_table")
    fun allGrades(): LiveData<MutableList<Grade>>

    @Query("select * from grade_table where idStudent = :studentId")
    fun getStudentsGrades(studentId: Int) : LiveData<MutableList<Grade>>
}