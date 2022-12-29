package com.example.clefnotes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Answer::class], version = 1)
abstract class ClefNotesDatabase : RoomDatabase() {
    abstract fun answerDao(): AnswerDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ClefNotesDatabase? = null

        fun getDatabase(context: Context): ClefNotesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClefNotesDatabase::class.java,
                    "clef_notes_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}