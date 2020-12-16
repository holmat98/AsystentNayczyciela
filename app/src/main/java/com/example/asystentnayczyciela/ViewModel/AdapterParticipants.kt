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

class AdapterParticipants(var ParticipantsList: LiveData<MutableList<Student>>): RecyclerView.Adapter<AdapterParticipants.ParticipantHolder>() {
    inner class ParticipantHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_participants,parent,false)
        return ParticipantHolder(view)
    }

    override fun onBindViewHolder(holder: ParticipantHolder, position: Int) {
        var name = holder.itemView.findViewById<TextView>(R.id.participantNameTV)
        var lastName = holder.itemView.findViewById<TextView>(R.id.participantLastNameTV)
        var addGrade = holder.itemView.findViewById<Button>(R.id.addGrade)
        var delete = holder.itemView.findViewById<Button>(R.id.deleteParticipant)

        name.text = ParticipantsList.value?.get(position)?.name
        lastName.text = ParticipantsList.value?.get(position)?.lastName

        addGrade.setOnClickListener {
            view -> view.findNavController().navigate(R.id.action_fragmentParticipants_to_fragmentAddGrade)
            DataSource.chosenParticipantId = ParticipantsList.value?.get(position)?.id ?: 0
        }

        delete.setOnClickListener {
            ParticipantsList.value?.removeAt(position)
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return ParticipantsList.value?.size?:0
    }
}