package com.example.clefnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.clefnotes.room.Answer
import java.util.*
import kotlin.collections.ArrayList


class PlayFragment : Fragment(), GuitarListenerDelegate {
    private var currentBeat = 0
    private val BEATS_PER_BAR = 4
    private var currentBar = 0
    private val NUMBER_OF_BARS = 4

    private var barAnswers: ArrayList<Answer> = arrayListOf()

    private lateinit var beatStartTime: Date

    private lateinit var playedNote1: EditText
    private lateinit var playedNote2: EditText
    private lateinit var playedNote3: EditText
    private lateinit var playedNote4: EditText

    private lateinit var bar: Bar

    private val playViewModel: PlayViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        playedNote1 = view.findViewById(R.id.playedNote1)
        playedNote2 = view.findViewById(R.id.playedNote2)
        playedNote3 = view.findViewById(R.id.playedNote3)
        playedNote4 = view.findViewById(R.id.playedNote4)

        bar = view.findViewById(R.id.bar)
        val guitar = view.findViewById<Guitar>(R.id.guitar)
        guitar.delegate = this

        bar.createNewRound()
        beatStartTime = Date()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun didPlayNote(note: Note) {
        val milliseconds = Date().time - beatStartTime.time
        barAnswers.add(Answer(note, bar.notes[currentBeat], milliseconds))

        if (currentBeat == 0) {
            playedNote1.setText(note.toString())
        } else if (currentBeat == 1) {
            playedNote2.setText(note.toString())
        } else if (currentBeat == 2) {
            playedNote3.setText(note.toString())
        } else {
            playedNote4.setText(note.toString())
            updateData()
        }

        currentBeat++

        if (currentBeat == BEATS_PER_BAR) {
            currentBar++

            if (currentBar == NUMBER_OF_BARS) {
                gameOver()
            }

            currentBeat = 0
        }

        beatStartTime = Date()
    }

    private fun updateData() {
        playViewModel.bars.value?.add(barAnswers)

        barAnswers = arrayListOf()
        bar.createNewRound()
        beatStartTime = Date()

        playedNote1.setText("")
        playedNote2.setText("")
        playedNote3.setText("")
        playedNote4.setText("")
    }

    private fun gameOver() {
        printGameSummary()

        findNavController().navigate(R.id.action_playFragment_to_gameSummaryFragment)
    }

    private fun printGameSummary() {
        playViewModel.bars.value?.let {
            for ((index, bar) in it.withIndex()) {
                println("Bar " + (index + 1))
                for (answer in bar) {
                    println("User Answer: " + answer.userAnswer)
                    println("Correct Answer: " + answer.correctAnswer)
                    println("Correct?: " + answer.isCorrect())
                    println("Time: " + answer.timeMS)
                }
            }
        }
    }
}