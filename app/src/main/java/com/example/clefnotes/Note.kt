package com.example.clefnotes

import java.util.*

enum class Note {
    HIGH_G,
    HIGH_F,
    HIGH_E,
    HIGH_D,
    OTHER;

    override fun toString(): String {
        when (this) {
            HIGH_G -> return "G"
            HIGH_F -> return "F"
            HIGH_E -> return "E"
            HIGH_D -> return "D"
            OTHER -> return "N/A"
        }
    }

    companion object {
        private val random = Random()

        fun randomNote(): Note {
            val valuesWithoutOther = values().toMutableList()
            valuesWithoutOther.remove(OTHER)
            return valuesWithoutOther[random.nextInt(valuesWithoutOther.size)]
        }
    }
}