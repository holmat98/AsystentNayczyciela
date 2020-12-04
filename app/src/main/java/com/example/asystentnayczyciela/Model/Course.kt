package com.example.asystentnayczyciela.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "course_table", foreignKeys = [
    ForeignKey(
        entity = Teacher::class,
        parentColumns = ["id"],
        childColumns = ["teacher"],
        onDelete = CASCADE
    )
])
class Course(@PrimaryKey(autoGenerate = true) val id: Int, var name: String, val teacher: Int) {
}