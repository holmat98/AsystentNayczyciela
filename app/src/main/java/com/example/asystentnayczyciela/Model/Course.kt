package com.example.asystentnayczyciela.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "course_table", foreignKeys = [
    ForeignKey(
        entity = Teacher::class,
        parentColumns = ["id"],
        childColumns = ["idTeacher"],
        onDelete = CASCADE
    )
])
data class Course(@PrimaryKey(autoGenerate = true)val id: Int, val idTeacher: Int, var name: String) {
}