package com.example.asystentnayczyciela.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ParticipantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(participant: Participant)

    @Delete
    suspend fun delete(participant: Participant)

    @Query("select * from participant_table")
    fun allParticipants(): LiveData<MutableList<Participant>>
}