package com.example.clefnotes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.clefnotes.room.Answer
import kotlin.system.exitProcess

class GameSummaryFragment : Fragment() {
    private val playViewModel: PlayViewModel by navGraphViewModels(R.id.nav_graph) {
        PlayViewModelFactory((activity?.application as ClefNotesApplication).repository)
    }

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

        recyclerView.adapter = GameSummaryAdapter(immutableDataset)

        setUpMenu()
    }

    private fun setUpMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onPrepareMenu(menu: Menu) {
                // Handle for example visibility of menu items
            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.game_summary_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.gameSummarySaveButton -> {
                        playViewModel.save()
                        findNavController().navigate(R.id.action_gameSummaryFragment_to_mainFragment)
                    }
                    else -> {
                        println("Invalid game summary menu button pressed")
                        exitProcess(1)
                    }
                }
                // Validate and handle the selected menu item
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}