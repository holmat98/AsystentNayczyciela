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

class AdapterNotParticipants(var notParticipantsList: LiveData<MutableList<Student>>): RecyclerView.Adapter<AdapterNotParticipants.NotParticipantHolder>() {
    inner class NotParticipantHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotParticipantHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_not_participants,parent,false)
        return NotParticipantHolder(view)
    }

    override fun onBindViewHolder(holder: NotParticipantHolder, position: Int) {
        var name = holder.itemView.findViewById<TextView>(R.id.notPName)
        var lastName = holder.itemView.findViewById<TextView>(R.id.notPLastName)
        var button = holder.itemView.findViewById<Button>(R.id.addParticipant)

        name.text = notParticipantsList.value?.get(position)?.name
        lastName.text = notParticipantsList.value?.get(position)?.lastName

        button.setOnClickListener{
            view -> view.findNavController().navigate(R.id.action_fragmentNotParticipants_to_fragmentAddParticipant)
            DataSource.newParticipantId = notParticipantsList.value?.get(position)?.id ?: 0
            DataSource.student = notParticipantsList.value?.get(position)?.name + " " + notParticipantsList.value?.get(position)?.lastName
        }
    }

    override fun getItemCount(): Int {
        return notParticipantsList.value?.size?:0
    }
}