package com.example.clefnotes.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.clefnotes.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface AnswerDao {
    @Insert
    suspend fun insert(answers: List<Answer>)

    @Query("SELECT * FROM Answer WHERE correct_answer = :note")
    fun getAllForNote(note: Note): Flow<List<Answer>>
}