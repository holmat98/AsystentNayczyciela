package com.example.asystentnayczyciela.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.asystentnayczyciela.Model.Converters.DateConverter
import java.util.Date

@Entity(tableName = "grade_table", foreignKeys = [
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
@TypeConverters(DateConverter::class)
data class Grade(@PrimaryKey(autoGenerate = true)val id: Int, val idStudent: Int, val idCourse: Int, var gradeValue: String, var gradeDescription: String, var date: Date) {
}