package com.example.fitnesskit.feature.data.repository

import com.example.fitnesskit.feature.data.api.ScheduleApi
import com.example.fitnesskit.feature.domaine.repository.ScheduleRepository

class ScheduleRepositoryImpl(private val scheduleApi: ScheduleApi) : ScheduleRepository {

    override suspend fun getSchedule(clubId: Int) =
        scheduleApi.getScheduleByClubId(clubId).toSchedule()
}