package com.org.hackathon.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.org.hackathon.databinding.ActivityMeetingroomBinding

class MeetingroomActivity : AppCompatActivity() {

    lateinit var binding: ActivityMeetingroomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeetingroomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backBtn1.setOnClickListener {
            finish()
        }


    }
}