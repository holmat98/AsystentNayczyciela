package com.example.asystentnayczyciela.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "participant_table", foreignKeys = [
    ForeignKey(
        entity = Student::class,
        parentColumns = ["id"],
        childColumns = ["idStudent"],
        onDelete = CASCADE
    ),
    ForeignKey(
        entity = Course::class,
        parentColumns = ["id"],
        childColumns = ["idCourse"],
        onDelete = CASCADE
    )
])
data class Participant(@PrimaryKey(autoGenerate = true)val id: Int, val idStudent: Int, val idCourse: Int) {
}