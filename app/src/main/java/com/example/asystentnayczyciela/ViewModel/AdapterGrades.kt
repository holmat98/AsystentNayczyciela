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
            .inflate(R.layout.one_row_grades,parent,false)
        return GradesHolder(view)
    }

    override fun onBindViewHolder(holder: GradesHolder, position: Int) {
        var grade = holder.itemView.findViewById<TextView>(R.id.gradeVTV)
        var description = holder.itemView.findViewById<TextView>(R.id.gradeDesTV)
        var date = holder.itemView.findViewById<TextView>(R.id.gradeDateTV)

        grade.text = gradesList.value?.get(position)?.gradeValue
        description.text = gradesList.value?.get(position)?.gradeDescription
        date.text = gradesList.value?.get(position)?.date
    }

    override fun getItemCount(): Int {
        return gradesList.value?.size?:0
    }
}