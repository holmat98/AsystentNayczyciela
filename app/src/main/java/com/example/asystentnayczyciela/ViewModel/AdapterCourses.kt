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

class AdapterCourses(var coursesList: LiveData<MutableList<Course>>): RecyclerView.Adapter<AdapterCourses.CoursesHolder>() {
    inner class CoursesHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_teachers_courses,parent,false)
        return CoursesHolder(view)
    }

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        var idTV = holder.itemView.findViewById<TextView>(R.id.courseId)
        var teacherIdTV = holder.itemView.findViewById<TextView>(R.id.teacherId)
        var nameTV = holder.itemView.findViewById<TextView>(R.id.courseNameTV)
        //var button = holder.itemView.findViewById<Button>(R.id.goToParticipantsBtn)

        idTV.text = coursesList.value?.get(position)?.id.toString()
        teacherIdTV.text = coursesList.value?.get(position)?.idTeacher.toString()
        nameTV.text = coursesList.value?.get(position)?.name
    }

    override fun getItemCount(): Int {
        return coursesList.value?.size?:0
    }
}