package com.example.clefnotes

import java.util.*

enum class Note {
    HIGH_G,
    HIGH_F,
    HIGH_E;

    companion object {
        private val random = Random()

        fun randomNote(): Note {
            return values()[random.nextInt(values().size)]
        }
    }
}