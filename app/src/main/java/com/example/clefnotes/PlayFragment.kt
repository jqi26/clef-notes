package com.example.clefnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText


class PlayFragment : Fragment(), GuitarListenerDelegate {

    private lateinit var playedNote1: EditText
    private lateinit var playedNote2: EditText
    private lateinit var playedNote3: EditText
    private lateinit var playedNote4: EditText

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

        val bar = view.findViewById<Bar>(R.id.bar)
        val guitar = view.findViewById<Guitar>(R.id.guitar)
        guitar.delegate = this

        bar.createNewRound()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun didPlayNote(note: Note) {
        if (playedNote1.text.isEmpty()) {
            playedNote1.setText(note.toString())
        } else if (playedNote2.text.isEmpty()) {
            playedNote2.setText(note.toString())
        } else if (playedNote3.text.isEmpty()) {
            playedNote3.setText(note.toString())
        } else {
            playedNote4.setText(note.toString())
        }
    }
}