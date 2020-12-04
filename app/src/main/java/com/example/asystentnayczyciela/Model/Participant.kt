package com.example.asystentnayczyciela.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "participant_table", foreignKeys = [
    ForeignKey(
        entity = Student::class,
        parentColumns = ["id"],
        childColumns = ["student"]
    ),
    ForeignKey(
        entity = Course::class,
        parentColumns = ["id"],
        childColumns = ["course"]
    )
])
class Participant(@PrimaryKey(autoGenerate = true) val id: Int, val student: Int, val course: Int) {
}