package com.example.clefnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPlayButton(view)
        setUpStatsButton(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun setUpPlayButton(view: View) {
        view.findViewById<Button>(R.id.playButton).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_playFragment)
        }
    }

    private fun setUpStatsButton(view: View) {
        view.findViewById<Button>(R.id.statsButton).setOnClickListener {
            println("Stas pressed!")
        }
    }
}