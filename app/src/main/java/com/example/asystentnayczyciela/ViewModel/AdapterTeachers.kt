package com.example.asystentnayczyciela.ViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.Model.Teacher
import com.example.asystentnayczyciela.R

class AdapterTeachers(var teacherList: LiveData<MutableList<Teacher>>): RecyclerView.Adapter<AdapterTeachers.StudentHolder>() {
    inner class StudentHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_teachers,parent,false)
        return StudentHolder(view)
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        var textViewIndex= holder.itemView.findViewById<TextView>(R.id.teacherIndex)
        var textViewFirstName= holder.itemView.findViewById<TextView>(R.id.teacherNameOR)
        var textViewLastName= holder.itemView.findViewById<TextView>(R.id.teacherLastNameOR)
        var buttonSV = holder.itemView.findViewById<Button>(R.id.goToTeacherView)

        textViewIndex.text = teacherList.value?.get(position)?.id.toString()
        textViewFirstName.text= teacherList.value?.get(position)?.name
        textViewLastName.text= teacherList.value?.get(position)?.lastName

        buttonSV.setOnClickListener{
            view -> view.findNavController().navigate(R.id.action_fragmentChooseTeacher_to_choosenTeacher)
            DataSource.chosenTeacherIndex = position
        }
    }

    override fun getItemCount(): Int {
        return teacherList.value?.size?:0
    }
}