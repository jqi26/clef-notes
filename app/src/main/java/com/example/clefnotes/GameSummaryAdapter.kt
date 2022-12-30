package com.example.clefnotes

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clefnotes.room.Answer
import java.math.RoundingMode

class GameSummaryAdapter(private val dataSet: List<List<Answer>>) :
    RecyclerView.Adapter<GameSummaryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bar: Bar
        val correctAnswerBeat1: TextView
        val correctAnswerBeat2: TextView
        val correctAnswerBeat3: TextView
        val correctAnswerBeat4: TextView

        val userAnswerBeat1: TextView
        val userAnswerBeat2: TextView
        val userAnswerBeat3: TextView
        val userAnswerBeat4: TextView

        val timeBeat1: TextView
        val timeBeat2: TextView
        val timeBeat3: TextView
        val timeBeat4: TextView

        init {
            bar = view.findViewById(R.id.gameSummaryBar)
            correctAnswerBeat1 = view.findViewById(R.id.correctAnswerBeat1)
            correctAnswerBeat2 = view.findViewById(R.id.correctAnswerBeat2)
            correctAnswerBeat3 = view.findViewById(R.id.correctAnswerBeat3)
            correctAnswerBeat4 = view.findViewById(R.id.correctAnswerBeat4)

            userAnswerBeat1 = view.findViewById(R.id.userAnswerBeat1)
            userAnswerBeat2 = view.findViewById(R.id.userAnswerBeat2)
            userAnswerBeat3 = view.findViewById(R.id.userAnswerBeat3)
            userAnswerBeat4 = view.findViewById(R.id.userAnswerBeat4)

            timeBeat1 = view.findViewById(R.id.timeBeat1)
            timeBeat2 = view.findViewById(R.id.timeBeat2)
            timeBeat3 = view.findViewById(R.id.timeBeat3)
            timeBeat4 = view.findViewById(R.id.timeBeat4)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.game_summary_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val bar = dataSet[position]
        viewHolder.bar.showNotes(bar.map { it.correctAnswer })

        viewHolder.correctAnswerBeat1.text = bar[0].correctAnswer.toString()
        viewHolder.correctAnswerBeat2.text = bar[1].correctAnswer.toString()
        viewHolder.correctAnswerBeat3.text = bar[2].correctAnswer.toString()
        viewHolder.correctAnswerBeat4.text = bar[3].correctAnswer.toString()

        viewHolder.userAnswerBeat1.text = bar[0].userAnswer.toString()
        viewHolder.userAnswerBeat2.text = bar[1].userAnswer.toString()
        viewHolder.userAnswerBeat3.text = bar[2].userAnswer.toString()
        viewHolder.userAnswerBeat4.text = bar[3].userAnswer.toString()

        viewHolder.timeBeat1.text = "%.1f".format((bar[0].timeMS / 1000.0).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN))
        viewHolder.timeBeat2.text = "%.1f".format((bar[1].timeMS / 1000.0).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN))
        viewHolder.timeBeat3.text = "%.1f".format((bar[2].timeMS / 1000.0).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN))
        viewHolder.timeBeat4.text = "%.1f".format((bar[3].timeMS / 1000.0).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN))

        viewHolder.userAnswerBeat1.setTextColor(if (bar[0].userAnswer == bar[0].correctAnswer) Color.GREEN else Color.RED)
        viewHolder.userAnswerBeat2.setTextColor(if (bar[1].userAnswer == bar[1].correctAnswer) Color.GREEN else Color.RED)
        viewHolder.userAnswerBeat3.setTextColor(if (bar[2].userAnswer == bar[2].correctAnswer) Color.GREEN else Color.RED)
        viewHolder.userAnswerBeat4.setTextColor(if (bar[3].userAnswer == bar[3].correctAnswer) Color.GREEN else Color.RED)
    }

    override fun getItemCount() = dataSet.size

}
