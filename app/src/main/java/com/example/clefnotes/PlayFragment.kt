package com.example.clefnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class PlayFragment : Fragment(), GuitarListenerDelegate {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bar = view.findViewById<Bar>(R.id.bar)
        val guitar = view.findViewById<Guitar>(R.id.guitar)
        guitar.delegate = this

        bar.createNewRound()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun didPlayNote(note: Note) {
        println(note)
    }
}