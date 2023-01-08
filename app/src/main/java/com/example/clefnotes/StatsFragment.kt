package com.example.clefnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.clefnotes.room.Answer

class StatsFragment : Fragment() {
    private val stats: MutableList<Stat> = mutableListOf()
    private val adapter = StatsAdapter(stats)

    private val statsViewModel: StatsViewModel by activityViewModels {
        StatsViewModelFactory((activity?.application as ClefNotesApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.statsRecyclerView)
        recyclerView.adapter = adapter

        statsViewModel.highEAnswers.observe(viewLifecycleOwner) { answers ->
            updateStatsForNote(Note.HIGH_E, answers)
        }

        statsViewModel.highFAnswers.observe(viewLifecycleOwner) { answers ->
            updateStatsForNote(Note.HIGH_F, answers)
        }

        statsViewModel.highGAnswers.observe(viewLifecycleOwner) { answers ->
            updateStatsForNote(Note.HIGH_G, answers)
        }

        statsViewModel.highDAnswers.observe(viewLifecycleOwner) { answers ->
            updateStatsForNote(Note.HIGH_D, answers)
        }
    }

    private fun updateStatsForNote(note: Note, answers: List<Answer>) {
        val averageTime = answers.map { it.timeMS }.average()

        var correctCount = 0

        for (answer in answers) {
            if (answer.userAnswer == answer.correctAnswer) {
                correctCount++
            }
        }

        val accuracy: Double = if (answers.isNotEmpty()) correctCount.toDouble() / answers.count() else 0.0

        val stat = Stat(note, averageTime.toLong(), accuracy)

        val index = stats.indexOf(stat)
        if (index == -1) {
            stats.add(stat)
            adapter.notifyItemInserted(-1)
        } else {
            stats[index] = stat
            adapter.notifyItemChanged(index)
        }
    }
}