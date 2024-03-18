package com.org.hackathon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.org.hackathon.R

class TimeSlotMeetingAdapter(private val items: List<String>,private val items2: List<String>) : RecyclerView.Adapter<TimeSlotMeetingAdapter.TimeSlotMeetingViewHolder>() {



    inner class TimeSlotMeetingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTimeSlot: TextView = itemView.findViewById(R.id.textViewTimeSlot1)
        private val textViewTimeSlot0: TextView = itemView.findViewById(R.id.textViewTimeSlot2)

        fun bind(item: String, item2: String) {
            // Set the time slot text to both TextViews
            textViewTimeSlot.text = item
            textViewTimeSlot0.text = item2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeSlotMeetingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.time_pic_meeting, parent, false)
        return TimeSlotMeetingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TimeSlotMeetingViewHolder, position: Int) {
        val item1 = items[position]
        val item2 = items2[position]
        holder.bind(item1,item2)
    }
}