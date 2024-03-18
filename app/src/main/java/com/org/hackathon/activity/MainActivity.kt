package com.org.hackathon.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.org.hackathon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BookStation.setOnClickListener {
            val intent = Intent(this, BookWorkStationActivity::class.java)
            startActivity(intent)
        }
        binding.MeetingRoom.setOnClickListener {
            val intent = Intent(this, MeetingroomActivity::class.java)
            startActivity(intent)

        }


    }
}