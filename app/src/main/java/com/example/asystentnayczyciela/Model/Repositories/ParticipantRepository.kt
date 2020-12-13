package com.example.asystentnayczyciela.Model.Repositories

import androidx.lifecycle.LiveData
import com.example.asystentnayczyciela.Model.Participant
import com.example.asystentnayczyciela.Model.ParticipantDao
import com.example.asystentnayczyciela.Model.Student

class ParticipantRepository(val participantDao: ParticipantDao) {
    val readAll: LiveData<MutableList<Participant>> = participantDao.allParticipants()

    suspend fun add(participant: Participant) {
        participantDao.insert(participant)
    }

    suspend fun delete(participant: Participant)=participantDao.delete(participant)
}