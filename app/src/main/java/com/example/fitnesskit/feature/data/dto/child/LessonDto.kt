package com.example.fitnesskit.feature.data.dto.child

import com.example.fitnesskit.feature.domaine.model.childe.Lesson
import com.google.gson.annotations.SerializedName

class LessonDto(
    private val color: String,
    private val commercial: Boolean,
    private val date: String,
    private val description: String,
    private val endTime: String,
    private val name: String,
    private val place: String,
    private val tab: String,
    private val startTime: String,
    @SerializedName("tab_id") private val tabId: Int,
    @SerializedName("appointment_id") private val appointmentId: String,
    @SerializedName("available_slots") private val availableSlots: Int,
    @SerializedName("client_recorded") private val clientRecorded: Boolean,
    @SerializedName("coach_id") private val coachId: String,
    @SerializedName("service_id") private val serviceId: String,
    @SerializedName("is_cancelled") private val cancelled: Boolean,
) {
    fun toLesson() = Lesson(
        color,
        commercial,
        date,
        description,
        endTime,
        name,
        place,
        startTime,
        tab,
        tabId,
        appointmentId,
        availableSlots,
        clientRecorded,
        coachId,
        serviceId,
        cancelled
    )
}