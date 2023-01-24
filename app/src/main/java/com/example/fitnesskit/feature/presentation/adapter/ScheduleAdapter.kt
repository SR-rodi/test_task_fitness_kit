package com.example.fitnesskit.feature.presentation.adapter

import com.example.fitnesskit.feature.presentation.adapter.delegate.delegateScheduleCard
import com.example.fitnesskit.feature.presentation.adapter.delegate.delegateScheduleCardDate
import com.example.fitnesskit.feature.presentation.model.ScheduleUi
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ScheduleAdapter : ListDelegationAdapter<List<ScheduleUi>>() {
    init {
        delegatesManager.addDelegate(delegateScheduleCard())
            .addDelegate(delegateScheduleCardDate())
    }
}