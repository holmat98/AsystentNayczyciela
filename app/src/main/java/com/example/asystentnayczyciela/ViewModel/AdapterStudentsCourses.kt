package com.example.asystentnayczyciela.ViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.asystentnayczyciela.Model.Course
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.Model.Student
import com.example.asystentnayczyciela.R

class AdapterStudentsCourses(var studentCList: LiveData<MutableList<Course>>): RecyclerView.Adapter<AdapterStudentsCourses.StudentsCHolder>() {
    inner class StudentsCHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsCHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_student_courses,parent,false)
        return StudentsCHolder(view)
    }

    override fun onBindViewHolder(holder: StudentsCHolder, position: Int) {
        var name = holder.itemView.findViewById<TextView>(R.id.cName)
        var button = holder.itemView.findViewById<Button>(R.id.gradesFromCourse)

        name.text = studentCList.value?.get(position)?.name

        button.setOnClickListener {
            view -> view.findNavController().navigate(R.id.action_fragmentStudentsCourses_to_fragmentStudentsGrades)
            DataSource.chosenStudentsCourseId = studentCList.value?.get(position)?.id ?: 0
        }

    }

    override fun getItemCount(): Int {
        return studentCList.value?.size?:0
    }
}