package com.example.asystentnayczyciela.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "student_table")
class Student(@PrimaryKey(autoGenerate = true) val id: Int, var name: String, var lastName: String) {

    override fun toString(): String {
        return name + " " + lastName
    }
}