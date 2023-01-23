package com.example.fitnesskit.feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskit.core.toListScheduleCard
import com.example.fitnesskit.feature.domaine.model.Schedule
import com.example.fitnesskit.feature.domaine.usecase.ScheduleUseCase
import com.example.fitnesskit.feature.presentation.model.ScheduleCard
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ScheduleViewModel(
    private val scheduleRepository: ScheduleUseCase,
) : ViewModel() {

    private val _schedule = MutableSharedFlow<List<ScheduleCard>>()
    val schedule = _schedule.asSharedFlow()

    init {
        // так как в примере id клуба статический нет смысла дергать метод во фрагменте
        getScheduleByClubID()
    }

    private fun getScheduleByClubID() =
        viewModelScope.launch {
            _schedule.emit(scheduleRepository.getScheduleByClubId(CLUB_ID).toListScheduleCard())
        }


    companion object {
        private const val CLUB_ID = 2
    }
}