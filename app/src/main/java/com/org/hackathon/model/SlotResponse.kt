package com.org.hackathon.model

import com.google.gson.annotations.SerializedName

data class SlotResponse(@SerializedName("slots") val timeSlots: List<TimeSlot>)

data class TimeSlot(
    @SerializedName("slot_name") val slot_name: String,
    @SerializedName("slot_id") val slot_id: Int,
    @SerializedName("slot_active") val slot_active: Boolean
)
data class TimeSlot1(
    val startTime: String,
    val endTime: String
)


