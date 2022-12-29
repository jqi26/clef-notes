package com.example.clefnotes

import java.util.*

enum class Note {
    HIGH_G,
    HIGH_F,
    HIGH_E,
    OTHER;

    companion object {
        private val random = Random()

        fun randomNote(): Note {
            val valuesWithoutOther = values().toMutableList()
            valuesWithoutOther.remove(OTHER)
            return valuesWithoutOther[random.nextInt(valuesWithoutOther.size)]
        }
    }
}