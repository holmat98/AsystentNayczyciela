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
import com.example.asystentnayczyciela.Model.Student
import com.example.asystentnayczyciela.R

class AdapterStudents(var studentList: LiveData<MutableList<Student>>): RecyclerView.Adapter<AdapterStudents.StudentHolder>() {
    inner class StudentHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_students,parent,false)
        return StudentHolder(view)
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        var textViewIndex= holder.itemView.findViewById<TextView>(R.id.studentIndex)
        var textViewFirstName= holder.itemView.findViewById<TextView>(R.id.studentNameOR)
        var textViewLastName= holder.itemView.findViewById<TextView>(R.id.studentLastNameOR)
        var buttonSV = holder.itemView.findViewById<Button>(R.id.goToStudentView)

        textViewIndex.text = studentList.value?.get(position)?.id.toString()
        textViewFirstName.text=studentList.value?.get(position)?.name
        textViewLastName.text=studentList.value?.get(position)?.lastName

        buttonSV.setOnClickListener{
            view -> view.findNavController().navigate(R.id.action_framgentChooseStudent_to_fragmentChoosenStudent)
            DataSource.chosenStudentIndex = position
        }
    }

    override fun getItemCount(): Int {
        return studentList.value?.size?:0
    }
}