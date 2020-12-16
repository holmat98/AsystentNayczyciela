package com.example.asystentnayczyciela.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.asystentnayczyciela.Model.AssistentDatabase
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.Model.Participant
import com.example.asystentnayczyciela.Model.Repositories.ParticipantRepository
import com.example.asystentnayczyciela.Model.Repositories.StudentRepository
import com.example.asystentnayczyciela.Model.Student
import kotlinx.coroutines.launch

class ParticipantViewModel(application: Application): AndroidViewModel(application) {

    var notParticipants: LiveData<MutableList<Student>>
    val studentRepository: StudentRepository
    private val participantRepository: ParticipantRepository

    init{
        notParticipants = AssistentDatabase.getDatabase(application).studentDao().getNotParticipants(DataSource.chosenCourseId)
        studentRepository = StudentRepository(AssistentDatabase.getDatabase(application).studentDao())
        participantRepository = ParticipantRepository(AssistentDatabase.getDatabase(application).participantDao())
    }

    fun addParticipant(studentId: Int, courseId: Int)
    {
        viewModelScope.launch {
            participantRepository.add(Participant(id = 0, idStudent = studentId, idCourse = courseId))
        }
    }

    fun deleteParticipant(participant: Participant){
        viewModelScope.launch {
            participantRepository.delete(participant)
        }
    }

}