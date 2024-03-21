package com.org.hackathon.activity

import RetrofitClient.apiService
import TimeSlotAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.datepicker.MaterialDatePicker

import com.org.hackathon.databinding.ActivityBookWorkStationBinding
import com.org.hackathon.model.SlotResponse
import com.org.hackathon.model.TimeSlot
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone



class BookWorkStationActivity : AppCompatActivity() {
    lateinit var binding: ActivityBookWorkStationBinding
    private lateinit var datePicker: MaterialDatePicker<Long>
    private val slotsAdapter = TimeSlotAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBookWorkStationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backBtn.setOnClickListener {
            finish()
        }
// Initialize ApiService
        apiService = RetrofitClient.apiService
        // Initialize RecyclerView
        binding.recyclerViewTimeSlots.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTimeSlots.adapter = slotsAdapter



        // Initialize MaterialDatePicker
        datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select Date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        // Handle date selection
        datePicker.addOnPositiveButtonClickListener { selectedDate ->
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            calendar.timeInMillis = selectedDate
            val selectedDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val selectedDateString = selectedDateFormat.format(calendar.time)
            // Fetch slots for the selected date
            fetchSlots(selectedDateString)

        }

        // Show date picker on button click
        binding.btnSelectDate.setOnClickListener {
            datePicker.show(supportFragmentManager, "DATE_PICKER")
        }
    }






    private fun fetchSlots(date: String) {

        apiService.getSlotsForDate(date).enqueue(object :Callback<SlotResponse>{
            override fun onResponse(call: Call<SlotResponse>, response: Response<SlotResponse>)
            {
                if (response.isSuccessful) {
                    val slotResponse = response.body()
                    slotResponse?.let {
                        displayTimeSlots(it.timeSlots)
                    }?: showError("Empty response body")
                } else {
                    // Handle unsuccessful response
                    Toast.makeText(applicationContext, "Failed to fetch slots", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<SlotResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Network error", Toast.LENGTH_SHORT).show()

            }

        })
    }

    private fun displayTimeSlots(timeSlots: List<TimeSlot>) {
        slotsAdapter.setSlots(timeSlots)
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
