package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ParticipantDao {

    @Insert
    suspend fun insert(participant: Participant)

    @Delete
    suspend fun delete(participant: Participant)

    @Query("select * from participant_table")
    fun allParticipants() : LiveData<List<Participant>>
}