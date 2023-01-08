package com.example.clefnotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.clefnotes.room.Answer
import com.example.clefnotes.room.AnswerRepository
import kotlinx.coroutines.launch

class PlayViewModel(private val answerRepository: AnswerRepository): ViewModel() {
    val bars = MutableLiveData<MutableList<MutableList<Answer>>>(arrayListOf())

    fun save() {
        bars.value?.let {
            viewModelScope.launch {
                answerRepository.insert(it.flatten())
            }
        }
    }
}

class PlayViewModelFactory(private val repository: AnswerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlayViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}