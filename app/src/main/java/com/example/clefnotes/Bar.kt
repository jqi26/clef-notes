package com.example.clefnotes

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.view.isInvisible
import kotlin.system.exitProcess

class Bar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {
    var notes: ArrayList<Note> = arrayListOf()

    private val firstHighGView: ImageView
    private val secondHighGView: ImageView
    private val thirdHighGView: ImageView
    private val fourthHighGView: ImageView

    private val firstHighFView: ImageView
    private val secondHighFView: ImageView
    private val thirdHighFView: ImageView
    private val fourthHighFView: ImageView

    private val firstHighEView: ImageView
    private val secondHighEView: ImageView
    private val thirdHighEView: ImageView
    private val fourthHighEView: ImageView

    private val firstHighDView: ImageView
    private val secondHighDView: ImageView
    private val thirdHighDView: ImageView
    private val fourthHighDView: ImageView

    init {
        inflate(context, R.layout.bar, this)

        firstHighGView = findViewById(R.id.firstHighG)
        secondHighGView = findViewById(R.id.secondHighG)
        thirdHighGView = findViewById(R.id.thirdHighG)
        fourthHighGView = findViewById(R.id.fourthHighG)

        firstHighFView = findViewById(R.id.firstHighF)
        secondHighFView = findViewById(R.id.secondHighF)
        thirdHighFView = findViewById(R.id.thirdHighF)
        fourthHighFView = findViewById(R.id.fourthHighF)

        firstHighEView = findViewById(R.id.firstHighE)
        secondHighEView = findViewById(R.id.secondHighE)
        thirdHighEView = findViewById(R.id.thirdHighE)
        fourthHighEView = findViewById(R.id.fourthHighE)

        firstHighDView = findViewById(R.id.firstHighD)
        secondHighDView = findViewById(R.id.secondHighD)
        thirdHighDView = findViewById(R.id.thirdHighD)
        fourthHighDView = findViewById(R.id.fourthHighD)
    }

    fun showNotes(notes: List<Note>) {
        for ((index, note) in notes.withIndex()) {
            showNote(index, note)
        }
    }

    fun createNewRound() {
        notes = arrayListOf()

        // Four beats in a bar. Could potentially support 3/4 and other time signatures later?
        for (i in 0..3) {
            notes.add(Note.randomNote())
        }

        update(notes)
    }

    private fun update(notes: List<Note>) {
        hideAllNotes()

        for ((index, note) in notes.withIndex()) {
            showNote(index, note)
        }
    }

    private fun showNote(index: Int, note: Note) {
        when (index) {
            0 -> {
                when (note) {
                    Note.HIGH_G -> firstHighGView.isInvisible = false
                    Note.HIGH_F -> firstHighFView.isInvisible = false
                    Note.HIGH_E -> firstHighEView.isInvisible = false
                    Note.HIGH_D -> firstHighDView.isInvisible = false
                    else -> { exitProcess(0) }
                }
            }
            1 -> {
                when (note) {
                    Note.HIGH_G -> secondHighGView.isInvisible = false
                    Note.HIGH_F -> secondHighFView.isInvisible = false
                    Note.HIGH_E -> secondHighEView.isInvisible = false
                    Note.HIGH_D -> secondHighDView.isInvisible = false
                    else -> { exitProcess(0) }
                }
            }
            2 -> {
                when (note) {
                    Note.HIGH_G -> thirdHighGView.isInvisible = false
                    Note.HIGH_F -> thirdHighFView.isInvisible = false
                    Note.HIGH_E -> thirdHighEView.isInvisible = false
                    Note.HIGH_D -> thirdHighDView.isInvisible = false
                    else -> { exitProcess(0) }
                }
            }
            3 -> {
                when (note) {
                    Note.HIGH_G -> fourthHighGView.isInvisible = false
                    Note.HIGH_F -> fourthHighFView.isInvisible = false
                    Note.HIGH_E -> fourthHighEView.isInvisible = false
                    Note.HIGH_D -> fourthHighDView.isInvisible = false
                    else -> { exitProcess(0) }
                }
            }
            else -> System.exit(0) // At a column not valid for current supported time signatures
        }
    }

    private fun hideAllNotes() {
        firstHighGView.isInvisible = true
        secondHighGView.isInvisible = true
        thirdHighGView.isInvisible = true
        fourthHighGView.isInvisible = true

        firstHighFView.isInvisible = true
        secondHighFView.isInvisible = true
        thirdHighFView.isInvisible = true
        fourthHighFView.isInvisible = true

        firstHighEView.isInvisible = true
        secondHighEView.isInvisible = true
        thirdHighEView.isInvisible = true
        fourthHighEView.isInvisible = true

        firstHighDView.isInvisible = true
        secondHighDView.isInvisible = true
        thirdHighDView.isInvisible = true
        fourthHighDView.isInvisible = true
    }
}