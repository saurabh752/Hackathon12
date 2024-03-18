package com.org.hackathon.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.hackathon.R
import com.org.hackathon.adapter.TimeSlotAdapter
import com.org.hackathon.databinding.ActivityLoginBinding
import com.org.hackathon.databinding.ActivityMeetingroomBinding

class MeetingroomActivity : AppCompatActivity() {

    lateinit var binding: ActivityMeetingroomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMeetingroomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backBtn1.setOnClickListener {
            finish()
        }

        val timeSlots = listOf("10:00AM - 11:00AM","01:00PM - 02:00PM","04:00PM - 05:00PM","06:00PM - 07:00PM","08:00PM - 09:00PM")
        val timeSlot = listOf("11:00AM - 12:00PM","02:00PM - 03:00PM","05:00PM - 06:00PM","07:00PM - 08:00PM","09:00PM - 10:00PM")
        // Set up RecyclerView
        val adapter = TimeSlotAdapter(timeSlots,timeSlot)
        binding.recyclerViewTimeSlots1.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTimeSlots1.adapter = adapter

    }
}