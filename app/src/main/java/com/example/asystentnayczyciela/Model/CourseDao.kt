package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select

@Dao
interface CourseDao {

    @Insert
    suspend fun insert(course: Course)

    @Delete
    suspend fun delete(course: Course)

    @Query("select * from course_table")
    fun AllCourses() : LiveData<MutableList<Course>>
}