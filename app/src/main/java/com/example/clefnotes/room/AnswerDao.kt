package com.example.clefnotes.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface AnswerDao {
    @Insert
    suspend fun insert(answers: List<Answer>)
}