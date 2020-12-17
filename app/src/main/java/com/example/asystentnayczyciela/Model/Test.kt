package com.example.asystentnayczyciela.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "test_table", foreignKeys = [
    ForeignKey(
        entity = Course::class,
        parentColumns = ["id"],
        childColumns = ["idCourse"],
        onDelete = CASCADE
    )
])
data class Test(@PrimaryKey(autoGenerate = true)val id: Int,val idCourse: Int, var topic: String, var testDate: String, var isActive: Boolean) {
}