package com.org.hackathon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.org.hackathon.R



class TimeSlotAdapter(private val items: List<String>,private val items2: List<String>) : RecyclerView.Adapter<TimeSlotAdapter.TimeSlotViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeSlotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.time_pic, parent, false)
        return TimeSlotViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeSlotViewHolder, position: Int) {
        val item1 = items[position]
        val item2 = items2[position]
        holder.bind(item1,item2)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class TimeSlotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTimeSlot1: TextView = itemView.findViewById(R.id.textViewTimeSlot1)
        private val textViewTimeSlot2: TextView = itemView.findViewById(R.id.textViewTimeSlot2)

        fun bind(item: String, item2: String) {
            // Set the time slot text to both TextViews
            textViewTimeSlot1.text = item
            textViewTimeSlot2.text = item2
        }
    }
}