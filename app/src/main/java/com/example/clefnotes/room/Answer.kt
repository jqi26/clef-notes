package com.example.clefnotes.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.clefnotes.Note

@Entity
class Answer(
    @ColumnInfo(name = "user_answer") var userAnswer: Note,
    @ColumnInfo(name = "correct_answer") var correctAnswer: Note,
    @ColumnInfo(name = "time_ms") var timeMS: Long,
) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0

    fun isCorrect(): Boolean {
        return this.userAnswer == this.correctAnswer
    }
}