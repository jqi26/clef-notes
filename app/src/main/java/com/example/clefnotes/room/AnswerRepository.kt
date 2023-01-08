package com.example.clefnotes.room

import com.example.clefnotes.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class AnswerRepository(private val answerDao: AnswerDao) {

    suspend fun insert(answers: List<Answer>) {
        withContext(Dispatchers.IO) {
            answerDao.insert(answers)
        }
    }

    fun getAllForNote(note: Note): Flow<List<Answer>> {
        return answerDao.getAllForNote(note)
    }
}