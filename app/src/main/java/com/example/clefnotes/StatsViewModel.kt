package com.example.clefnotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.clefnotes.room.Answer
import com.example.clefnotes.room.AnswerRepository

class StatsViewModel(private val answerRepository: AnswerRepository): ViewModel() {
    val highEAnswers: LiveData<List<Answer>> = answerRepository.getAllForNote(Note.HIGH_E).asLiveData()
    val highFAnswers: LiveData<List<Answer>> = answerRepository.getAllForNote(Note.HIGH_F).asLiveData()
    val highGAnswers: LiveData<List<Answer>> = answerRepository.getAllForNote(Note.HIGH_G).asLiveData()
    val highDAnswers: LiveData<List<Answer>> = answerRepository.getAllForNote(Note.HIGH_D).asLiveData()
}

class StatsViewModelFactory(private val repository: AnswerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StatsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}