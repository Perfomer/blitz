package com.perfomer.blitzapp.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.perfomer.blitz.setTimeAgo
import com.perfomer.blitzapp.util.format
import kotlinx.android.synthetic.main.item_main.view.*
import java.util.*

class TimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val relativeTime = itemView.item_relative_time
    private val dateTime = itemView.item_date

    fun bind(time: Date) {
        dateTime.text = time.format()
        relativeTime.setTimeAgo(time, showSeconds = true)
    }

}