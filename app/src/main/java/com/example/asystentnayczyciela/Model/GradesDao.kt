package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GradesDao {
    @Delete
    suspend fun delelte(grade: Grades)

    @Insert
    suspend fun insert(grade: Grades)

    @Query("select * from grades_table")
    fun allGrades() : LiveData<List<Grades>>
}