package com.example.fitnesskit.feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskit.core.toListScheduleUi
import com.example.fitnesskit.feature.domaine.usecase.ScheduleUseCase
import com.example.fitnesskit.feature.presentation.model.ScheduleUi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScheduleViewModel(
    private val scheduleRepository: ScheduleUseCase,
) : ViewModel() {

    private val _schedule = MutableStateFlow<List<ScheduleUi>>(emptyList())
    val schedule = _schedule.asStateFlow()

    init {
        // так как в примере id клуба статический нет смысла дергать метод во фрагменте
        getScheduleByClubID()
    }

    private fun getScheduleByClubID() =
        viewModelScope.launch {
            _schedule.emit(scheduleRepository.getScheduleByClubId(CLUB_ID).toListScheduleUi())
        }


    companion object {
        private const val CLUB_ID = 2
    }
}