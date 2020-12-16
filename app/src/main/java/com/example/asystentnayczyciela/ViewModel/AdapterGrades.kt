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
import com.example.asystentnayczyciela.Model.Grade
import com.example.asystentnayczyciela.R

class AdapterGrades(var gradesList: LiveData<MutableList<Grade>>): RecyclerView.Adapter<AdapterGrades.GradesHolder>() {
    inner class GradesHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradesHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_teachers_courses,parent,false)
        return GradesHolder(view)
    }

    override fun onBindViewHolder(holder: GradesHolder, position: Int) {
        val grade = holder.itemView.findViewById<TextView>(R.id.gradeVTV)
        val des = holder.itemView.findViewById<TextView>(R.id.gradeDesTV)

        grade.text = gradesList.value?.get(position)?.gradeValue
        des.text = gradesList.value?.get(position)?.gradeDescription + " " + gradesList.value?.get(position)?.date.toString()

        //grade.height = des.height
    }

    override fun getItemCount(): Int {
        return gradesList.value?.size?:0
    }
}