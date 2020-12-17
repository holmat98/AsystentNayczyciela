package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course)

    @Delete
    suspend fun delete(course: Course)

    @Query("select * from course_table")
    fun allCourses() : LiveData<MutableList<Course>>

    @Query("select * from course_table where idTeacher = :id")
    fun teachersCourses(id: Int) : LiveData<MutableList<Course>>

    @Query("select * from course_table where id in (select idCourse from participant_table where idStudent = :studentId)")
    fun studentsCourses(studentId: Int) : LiveData<MutableList<Course>>
}