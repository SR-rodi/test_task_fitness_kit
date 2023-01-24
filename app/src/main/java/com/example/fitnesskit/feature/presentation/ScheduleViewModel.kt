package com.example.fitnesskit.feature.presentation

import androidx.lifecycle.viewModelScope
import com.example.fitnesskit.core.BaseViewModel
import com.example.fitnesskit.core.LoadState
import com.example.fitnesskit.core.toListScheduleUi
import com.example.fitnesskit.feature.domaine.usecase.ScheduleUseCase
import com.example.fitnesskit.feature.presentation.model.ScheduleUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScheduleViewModel(
    private val scheduleRepository: ScheduleUseCase,
) : BaseViewModel<ScheduleUi>() {

    init {
        // так как в примере id клуба статический нет смысла дергать метод во фрагменте
        getScheduleByClubID()
    }

    private fun getScheduleByClubID() =
        viewModelScope.launch(Dispatchers.IO + handler) {
            _loadState.value = LoadState.LOADING
            _schedule.emit(scheduleRepository.getScheduleByClubId(CLUB_ID).toListScheduleUi())
            _loadState.value = LoadState.SUCCESS
        }

    companion object {
        private const val CLUB_ID = 2
    }
}