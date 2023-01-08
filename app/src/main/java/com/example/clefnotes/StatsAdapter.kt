package com.example.clefnotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Stat(val note: Note, val averageTime: Long, val accuracy: Double) {
    override fun equals(other: Any?): Boolean {
        if (other !is Stat) {
            return false
        }

        return this.note == other.note
    }

    override fun hashCode(): Int {
        return note.hashCode()
    }
}

class StatsAdapter(private val dataSet: List<Stat>) :
    RecyclerView.Adapter<StatsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val note: TextView
        val averageTime: TextView
        val accuracy: TextView

        init {
            note = view.findViewById(R.id.statsNoteText)
            averageTime = view.findViewById(R.id.averageTimeText)
            accuracy = view.findViewById(R.id.accuracyText)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.stats_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.note.text = dataSet[position].note.toString()
        viewHolder.averageTime.text = dataSet[position].averageTime.toString()
        viewHolder.accuracy.text = dataSet[position].accuracy.toString() + "%"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
