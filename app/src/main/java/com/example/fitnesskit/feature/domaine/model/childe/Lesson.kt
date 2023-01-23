package com.example.fitnesskit.feature.domaine.model.childe

import com.google.gson.annotations.SerializedName

class Lesson(
    val color: String,
    val commercial: Boolean,
    val date: String,
    val description: String,
    val endTime: String,
    val name: String,
    val place: String,
    val startTime: String,
    val tab: String,
    val tabId: Int,
    val appointmentId: String,
    val availableSlots: Int,
    val clientRecorded: Boolean,
    val coachId: String,
    val serviceId: String,
    val cancelled: Boolean,
)