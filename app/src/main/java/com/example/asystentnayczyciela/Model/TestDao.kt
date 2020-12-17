package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TestDao {
    @Insert
    suspend fun insert(test: Test)

    @Delete
    suspend fun delete(test: Test)

    @Update
    suspend fun update(test: Test)

    @Query("select * from test_table where idCourse in (select id from course_table where idTeacher = :teacherId)")
    fun getTeachersTest(teacherId: Int) : LiveData<MutableList<Test>>

    @Query("select * from test_table where idCourse in (select participant_table.idCourse from participant_table where idStudent = :studentId)")
    fun getTest(studentId: Int) : LiveData<MutableList<Test>>
}