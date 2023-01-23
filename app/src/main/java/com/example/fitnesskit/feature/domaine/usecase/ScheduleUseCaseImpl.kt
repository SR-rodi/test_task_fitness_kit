package com.example.fitnesskit.feature.domaine.usecase

import com.example.fitnesskit.feature.domaine.repository.ScheduleRepository

class ScheduleUseCaseImpl(
    private val scheduleRepository: ScheduleRepository,
) : ScheduleUseCase {
    override suspend fun getScheduleByClubId(clubID: Int) = scheduleRepository.getSchedule(clubID)
}