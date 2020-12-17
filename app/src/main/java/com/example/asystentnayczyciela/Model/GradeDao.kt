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

    @Query("select * from grade_table where idStudent = :studentId and idCourse = :courseId")
    fun getStudentsGrades(studentId: Int, courseId: Int) : LiveData<MutableList<Grade>>

    @Query("select * from grade_table where date = :todaysDate and idCourse in (select id from course_table where idTeacher = :teacherId)")
    fun report(todaysDate: String, teacherId: Int) : LiveData<MutableList<Grade>>
}