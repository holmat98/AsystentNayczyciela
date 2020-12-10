package com.example.asystentnayczyciela.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "grades_table", foreignKeys = [
    ForeignKey(
        entity = Student::class,
        parentColumns = ["id"],
        childColumns = ["id_student"],
        onDelete = CASCADE
    ),
    ForeignKey(
        entity = Teacher::class,
        parentColumns = ["id"],
        childColumns = ["id_teacher"],
        onDelete = CASCADE
    )
])
class Grades(@PrimaryKey(autoGenerate = true) val id: Int, val id_student: Int, val id_teacher: Int, var descritpion: String, var date: Date) {
}