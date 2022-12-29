package com.example.clefnotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clefnotes.room.Answer

class PlayViewModel: ViewModel() {
    val bars = MutableLiveData<MutableList<MutableList<Answer>>>(arrayListOf())
}