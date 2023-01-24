package com.example.fitnesskit.feature.presentation.adapter

import android.graphics.Color
import com.example.fitnesskit.databinding.ItemScheduleBinding
import com.example.fitnesskit.databinding.ItemScheduleDateBinding
import com.example.fitnesskit.feature.presentation.model.ScheduleCardDateUiModel
import com.example.fitnesskit.feature.presentation.model.ScheduleCardUiModel
import com.example.fitnesskit.feature.presentation.model.ScheduleUi
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class ScheduleAdapter() : ListDelegationAdapter<List<ScheduleUi>>() {
    init {
        delegatesManager.addDelegate(delegateScheduleCard())
            .addDelegate(delegateScheduleCardDate())

    }
}

fun delegateScheduleCard() =
    adapterDelegateViewBinding<ScheduleCardUiModel, ScheduleUi, ItemScheduleBinding>({ layoutInflater, root ->
        ItemScheduleBinding.inflate(
            layoutInflater,
            root,
            false
        )
    }) {

        bind {
            binding.apply {
                couch.text = item.trainerName
                startTime.text = item.startTime
                endTime.text = item.endTime
                work.text = item.workoutName
                location.text = item.studio
                color.setBackgroundColor(Color.parseColor(item.color))
            }
        }
    }


fun delegateScheduleCardDate() =
    adapterDelegateViewBinding<ScheduleCardDateUiModel, ScheduleUi, ItemScheduleDateBinding>({ layoutInflater, root ->
        ItemScheduleDateBinding.inflate(
            layoutInflater,
            root,
            false
        )
    }) {

        bind {
            binding.apply {
                date.text = item.date
                card.apply {
                    couch.text = item.trainerName
                    startTime.text = item.startTime
                    endTime.text = item.endTime
                    work.text = item.workoutName
                    location.text = item.studio
                    color.setBackgroundColor(Color.parseColor(item.color))
                }
            }
        }
    }