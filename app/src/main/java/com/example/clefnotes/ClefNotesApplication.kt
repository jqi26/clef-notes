package com.example.clefnotes

import android.app.Application
import com.example.clefnotes.room.AnswerRepository
import com.example.clefnotes.room.ClefNotesDatabase

class ClefNotesApplication: Application() {
    val database by lazy { ClefNotesDatabase.getDatabase(this) }
    val repository by lazy { AnswerRepository(database.answerDao()) }
}