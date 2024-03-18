package com.org.hackathon.activity

//import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.hackathon.adapter.TimeSlotAdapter
import com.org.hackathon.databinding.ActivityBookWorkStationBinding
//import com.org.hackathon.databinding.ActivityLoginBinding
//import devs.mulham.horizontalcalendar.HorizontalCalendar
//import devs.mulham.horizontalcalendar.HorizontalCalendarListener
//import devs.mulham.horizontalcalendar.HorizontalCalendarView
//import java.util.Calendar
//import java.util.Date


class BookWorkStationActivity : AppCompatActivity() {
    lateinit var binding: ActivityBookWorkStationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBookWorkStationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }
        //setupHorizontalCalendar()
        // Sample data for time slots
        val timeSlots = listOf("10:00AM - 11:00AM","01:00PM - 02:00PM","04:00PM - 05:00PM","06:00PM - 07:00PM","08:00PM - 09:00PM")
        val timeSlot = listOf("11:00AM - 12:00PM","02:00PM - 03:00PM","05:00PM - 06:00PM","07:00PM - 08:00PM","09:00PM - 10:00PM")
        // Set up RecyclerView
        val adapter = TimeSlotAdapter(timeSlots,timeSlot)
        binding.recyclerViewTimeSlots.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTimeSlots.adapter = adapter
    }


}

//    private fun setupHorizontalCalendar() {
//        val startDate = Calendar.getInstance()
//        startDate.add(Calendar.MONTH, -1)
//
//        val endDate = Calendar.getInstance()
//        endDate.add(Calendar.MONTH, 1)
//
//        val horizontalCalendar = HorizontalCalendar.Builder(this, binding.calendarView.id)
//            .range(startDate, endDate)
//            .datesNumberOnScreen(5)
//            .build()
//
//        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
//
//
//            override fun onCalendarScroll(calendarView: HorizontalCalendarView?, dx: Int, dy: Int) {
//                // Handle calendar scroll
//            }
//
//            override fun onDateSelected(date: Date?, position: Int) {
//                TODO("Not yet implemented")
//            }
//        }
//    }
//}
//
//fun HorizontalCalendar.Builder.range(startDate: Calendar, endDate: Calendar): HorizontalCalendar.Builder {
//    return this.range(startDate, endDate)
//}
