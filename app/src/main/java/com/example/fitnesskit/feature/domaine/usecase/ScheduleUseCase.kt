package com.example.fitnesskit.feature.domaine.usecase

import com.example.fitnesskit.feature.domaine.model.Schedule

interface ScheduleUseCase {

    suspend fun getScheduleByClubId(clubID:Int): Schedule
}