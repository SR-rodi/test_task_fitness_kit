package com.example.fitnesskit.feature.domaine.repository

import com.example.fitnesskit.feature.domaine.model.Schedule

interface ScheduleRepository {

    suspend fun getSchedule(clubId: Int): Schedule
}