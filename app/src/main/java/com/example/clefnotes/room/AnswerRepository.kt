package com.example.clefnotes.room

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnswerRepository(private val answerDao: AnswerDao) {
    suspend fun insert(answers: List<Answer>) {
        withContext(Dispatchers.IO) {
            answerDao.insert(answers)
        }
    }
}