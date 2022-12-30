package com.example.clefnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.clefnotes.room.Answer

class GameSummaryFragment : Fragment() {
    private val playViewModel: PlayViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.gameSummaryRecyclerVIew)

        var immutableDataset: List<List<Answer>> = listOf()
        playViewModel.bars.value?.let {
            immutableDataset = it.toList().map { it.toList() }
        }

        println(immutableDataset)

        recyclerView.adapter = GameSummaryAdapter(immutableDataset)
    }
}