package com.example.fitnesskit.feature.presentation.model

class ScheduleCardDateUiModel(
    override val trainerName: String,
    override val workoutName: String,
    override val startTime: String,
    override val endTime: String,
    override val studio: String,
    override val color: String,
    val date: String,
) : ScheduleUi